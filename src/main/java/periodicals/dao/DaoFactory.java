package periodicals.dao;

public interface DaoFactory {
    void close() throws PersistException;

    PeriodicalDao getPeriodicalDao();

    UserDao getUserDao();
}
