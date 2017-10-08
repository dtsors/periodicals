package periodicals.listeners;

import org.apache.log4j.Logger;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.dao.mysql.MySqlDaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info(">>App started");
        long currentTimeMillis = System.currentTimeMillis();
        final DaoFactory daoFactory = new MySqlDaoFactory();
        servletContextEvent.getServletContext().setAttribute("periodicals.model", daoFactory);
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        try {
            periodicalDao.getAllRecords();
        } catch (PersistException e) {
            LOGGER.error(">>Can't start DB", e);
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        LOGGER.info(">>DB started after " + currentTimeMillis);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DaoFactory daoFactory = (DaoFactory) servletContextEvent.getServletContext().getAttribute("periodicals.model");
        daoFactory.close();
        LOGGER.info(">>App closed");
    }
}
