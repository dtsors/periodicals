package periodicals.model.dao;

public interface DaoFactory {
    void close();

    PeriodicalDao getPeriodicalDao();

    UserDao getUserDao();
}
