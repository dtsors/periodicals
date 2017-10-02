package java.periodicals.dao;

import periodicals.dao.DaoFactory;
import periodicals.dao.PersistException;
import periodicals.dao.UserDao;
import periodicals.dao.mysql.MySqlDaoFactory;
import periodicals.domain.User;

import java.util.List;

public class Test {
    public static void main(String[] args) throws PersistException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        UserDao dao = daoFactory.getUserDao();
        List<User> users = dao.getAllRecords();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
