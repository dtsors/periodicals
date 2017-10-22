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

import static periodicals.Constants.APPLICATION_DAO;
import static periodicals.Constants.APPLICATION_LOGGER;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final Logger LOGGER = Logger.getLogger(ApplicationListener.class);
        servletContextEvent.getServletContext().setAttribute(APPLICATION_LOGGER, LOGGER);
        LOGGER.info(">>App started");
        long currentTimeMillis = System.currentTimeMillis();
        final DaoFactory daoFactory = new MySqlDaoFactory();
        servletContextEvent.getServletContext().setAttribute(APPLICATION_DAO, daoFactory);
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        try {
            periodicalDao.getAllRecords();
        } catch (PersistException e) {
            LOGGER.error(">>Can't start DB", e);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        LOGGER.info(">>DB started after " + currentTimeMillis + " milliseconds");
        new MailProperties();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        final Logger LOGGER = ((Logger) servletContextEvent.getServletContext().getAttribute(APPLICATION_LOGGER));
        DaoFactory daoFactory = (DaoFactory) servletContextEvent.getServletContext().getAttribute(APPLICATION_DAO);
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
