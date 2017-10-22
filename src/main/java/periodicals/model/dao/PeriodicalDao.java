package periodicals.model.dao;

import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import java.util.List;

public interface PeriodicalDao extends GenericDao<Periodical>{
    List<Periodical> getAllRecords(int a, int b) throws PersistException;
    int getCount() throws PersistException;
}
