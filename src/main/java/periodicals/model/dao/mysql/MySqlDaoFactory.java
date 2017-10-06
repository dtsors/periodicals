package periodicals.model.dao.mysql;

import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.UserDao;

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
