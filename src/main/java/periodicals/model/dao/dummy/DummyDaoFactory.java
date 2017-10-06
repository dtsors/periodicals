package periodicals.model.dao.dummy;

import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.UserDao;

public class DummyDaoFactory implements DaoFactory {
    @Override
    public void close() {

    }

    @Override
    public PeriodicalDao getPeriodicalDao() {
        return new DummyPeriodicalDao();
    }

    @Override
    public UserDao getUserDao() {
        return new DummyUserDao();
    }
}
