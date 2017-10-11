package periodicals.model.dao.mysql;

import periodicals.model.dao.PaymentDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Payment;

import java.util.List;

public class MySqlPaymentDao implements PaymentDao {
    @Override
    public int create(Payment o) throws PersistException {
        return 0;
    }

    @Override
    public int update(Payment o) throws PersistException {
        return 0;
    }

    @Override
    public int delete(int id) throws PersistException {
        return 0;
    }

    @Override
    public List<Payment> getAllRecords() throws PersistException {
        return null;
    }

    @Override
    public Payment getRecordById(int id) throws PersistException {
        return null;
    }
}
