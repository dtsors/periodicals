package periodicals.model.dao.mysql;

import periodicals.domain.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import java.util.List;

class MySqlTest {
    public static void main(String[] args) throws PersistException {
        DaoFactory daoFactory = new MySqlDaoFactory();
        UserDao dao = daoFactory.getUserDao();
        List<User> users = dao.getAllRecords();
        for (User user : users) {
            System.out.println(user);
        }
    }
}