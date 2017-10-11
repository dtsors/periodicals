package periodicals.listeners;

import org.apache.log4j.Logger;
import periodicals.MailSender;
import periodicals.model.config.MailProperties;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.dao.mysql.MySqlDaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.TimeUnit;

import static periodicals.Constants.SESSION_DAO;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info(">>App started");
        long currentTimeMillis = System.currentTimeMillis();
        final DaoFactory daoFactory = new MySqlDaoFactory();
        servletContextEvent.getServletContext().setAttribute(SESSION_DAO, daoFactory);
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        try {
            periodicalDao.getAllRecords();
        } catch (PersistException e) {
            LOGGER.error(">>Can't start DB", e);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        LOGGER.info(">>DB started after " + currentTimeMillis);
        new MailProperties();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DaoFactory daoFactory = (DaoFactory) servletContextEvent.getServletContext().getAttribute(SESSION_DAO);
        daoFactory.close();
        MailSender.getExecutor().shutdown();
        try {
            MailSender.getExecutor().awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error(">>Can't gracefully close mail threads", e);
        }
        LOGGER.info(">>App closed");
    }
}
