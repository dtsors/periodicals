package periodicals.model.dao;

import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

public interface UserDao extends GenericDao<User>{
    User getRecordByEmail(String email) throws PersistException;
    User getRecordByToken(String token) throws PersistException;
}
