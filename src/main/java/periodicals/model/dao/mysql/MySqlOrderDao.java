package periodicals.model.dao.mysql;

import periodicals.model.dao.OrderDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Order;

import java.util.List;

public class MySqlOrderDao implements OrderDao {
    @Override
    public int create(Order o) throws PersistException {
        return 0;
    }

    @Override
    public int update(Order o) throws PersistException {
        return 0;
    }

    @Override
    public int delete(int id) throws PersistException {
        return 0;
    }

    @Override
    public List<Order> getAllRecords() throws PersistException {
        return null;
    }

    @Override
    public Order getRecordById(int id) throws PersistException {
        return null;
    }
}
