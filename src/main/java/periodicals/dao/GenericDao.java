package periodicals.dao;

import java.util.List;

public interface GenericDao<T> {
    int save(T o) throws PersistException;
    int update(T o) throws PersistException;
    int delete(T o) throws PersistException;
    List<T> getAllRecords() throws PersistException;
    T getRecordById(int id) throws PersistException;
}
