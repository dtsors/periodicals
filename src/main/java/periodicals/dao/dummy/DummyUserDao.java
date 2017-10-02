package periodicals.dao.dummy;

import periodicals.dao.UserDao;
import periodicals.domain.User;
import periodicals.dao.PersistException;

import java.util.ArrayList;
import java.util.List;

public class DummyUserDao implements UserDao {
    @Override
    public int save(User o) throws PersistException {
        return 0;
    }

    @Override
    public int update(User o) throws PersistException {
        return 0;
    }

    @Override
    public int delete(User o) throws PersistException {
        return 0;
    }

    @Override
    public List<User> getAllRecords() throws PersistException {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @Override
    public User getRecordById(int id) throws PersistException {
        return null;
    }
}
