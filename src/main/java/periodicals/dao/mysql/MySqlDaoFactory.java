package periodicals.dao.mysql;

import periodicals.dao.DaoFactory;
import periodicals.dao.PeriodicalDao;
import periodicals.dao.UserDao;

public class MySqlDaoFactory implements DaoFactory {
    @Override
    public void close() {
        MySqlCP.getInstance().close();
    }

    @Override
    public PeriodicalDao getPeriodicalDao() {
        return new MySqlPeriodicalDao();
    }

    @Override
    public UserDao getUserDao() {
        return new MySqlUserDao();
    }
}
