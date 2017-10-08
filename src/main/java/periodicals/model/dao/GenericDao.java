package periodicals.model.dao;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.dao.mysql.MySqlPeriodicalDao;

import java.util.List;

public interface GenericDao<T> {
    Logger LOGGER = Logger.getLogger(GenericDao.class);
    int save(T o) throws PersistException;
    int update(T o) throws PersistException;
    int delete(T o) throws PersistException;
    List<T> getAllRecords() throws PersistException;
    T getRecordById(int id) throws PersistException;
}
