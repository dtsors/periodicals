package periodicals.dao.dummy;

import periodicals.dao.DaoFactory;
import periodicals.dao.PeriodicalDao;
import periodicals.dao.UserDao;
import periodicals.dao.PersistException;

public class DummyDaoFactory implements DaoFactory {
    @Override
    public void close() throws PersistException {

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
