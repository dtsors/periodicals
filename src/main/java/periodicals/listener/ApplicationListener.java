package periodicals.listener;

import periodicals.dao.DaoFactory;
import periodicals.dao.PeriodicalDao;
import periodicals.dao.PersistException;
import periodicals.dao.mysql.MySqlDaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">>App started");
        long currentTimeMillis = System.currentTimeMillis();
        final DaoFactory daoFactory = new MySqlDaoFactory();
        servletContextEvent.getServletContext().setAttribute("periodicals.dao", daoFactory);
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        try {
            periodicalDao.getAllRecords();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
        System.out.println(">>DB started after " + currentTimeMillis);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DaoFactory daoFactory = (DaoFactory) servletContextEvent.getServletContext().getAttribute("periodicals.dao");
        try {
            daoFactory.close();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        System.out.println(">>App closed");
    }
}
