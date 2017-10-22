package periodicals.model.dao;

import org.apache.log4j.Logger;
import periodicals.model.dao.exceptions.PersistException;

import java.util.List;

public interface GenericDao<T> {
    Logger LOGGER = Logger.getLogger(GenericDao.class);
    int create(T o) throws PersistException;
    int update(T o) throws PersistException;
    int delete(int id) throws PersistException;
    List<T> getAllRecords() throws PersistException;
    T getRecordById(int id) throws PersistException;
}
