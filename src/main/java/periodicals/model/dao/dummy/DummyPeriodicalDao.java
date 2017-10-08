package periodicals.model.dao.dummy;

import periodicals.model.dao.PeriodicalDao;
import periodicals.model.entity.Periodical;
import periodicals.model.dao.exceptions.PersistException;

import java.util.ArrayList;
import java.util.List;

public class DummyPeriodicalDao implements PeriodicalDao {
    @Override
    public int save(Periodical o) throws PersistException {
        return 0;
    }

    @Override
    public int update(Periodical o) throws PersistException {
        return 0;
    }

    @Override
    public int delete(Periodical o) throws PersistException {
        return 0;
    }

    @Override
    public List<Periodical> getAllRecords() throws PersistException {
        List<Periodical> periodicals = new ArrayList<>();
        periodicals.add(new Periodical());
        periodicals.add(new Periodical());
        periodicals.add(new Periodical());
        return periodicals;
    }

    @Override
    public Periodical getRecordById(int id) throws PersistException {
        return null;
    }
}
