package periodicals.model.dao.mysql;

import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPeriodicalDao implements PeriodicalDao {
    private static final String TABLE_NAME = "periodicals";

    @Override
    public int create(final Periodical periodical) throws PersistException {
        int status;
        String query = "INSERT INTO " + TABLE_NAME + "(name, description, issuesPerMonth, cost) VALUES(?,?,?,?)";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, periodical.getName());
            statement.setString(2, periodical.getDescription());
            statement.setInt(3, periodical.getIssuesPerMonth());
            statement.setBigDecimal(4, new BigDecimal(periodical.getCost()));
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't insert in " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int update(final Periodical periodical) throws PersistException {
        int status;
        String query = "UPDATE " + TABLE_NAME + " SET name=?,description=?,issuesPerMonth=?,cost=? WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, periodical.getName());
            statement.setString(2, periodical.getDescription());
            statement.setInt(3, periodical.getIssuesPerMonth());
            statement.setBigDecimal(4, new BigDecimal(periodical.getCost()));
            statement.setInt(5, periodical.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't update " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int delete(final int id) throws PersistException {
        int status;
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't delete from " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public List<Periodical> getAllRecords() throws PersistException {
        List<Periodical> periodicals = new ArrayList<>();
        String query = "SELECT id, name, description, issuesPerMonth, cost FROM " + TABLE_NAME;
        getAllRecordsDublicated(periodicals, query);
        return periodicals;
    }

    @Override
    public List<Periodical> getAllRecords(int a, int b) throws PersistException {
        List<Periodical> periodicals = new ArrayList<>();
        String query = "SELECT id, name, description, issuesPerMonth, cost FROM " + TABLE_NAME + " order by id LIMIT " + a + ", " + b;
        getAllRecordsDublicated(periodicals, query);
        return periodicals;
    }

    private void getAllRecordsDublicated(List<Periodical> periodicals, String query) throws PersistException {
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query);
             final ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Periodical periodical = new Periodical();
                periodical.setId(resultSet.getInt("id"));
                periodical.setName(resultSet.getString("name"));
                periodical.setDescription(resultSet.getString("description"));
                periodical.setIssuesPerMonth(resultSet.getInt("issuesPerMonth"));
                periodical.setCost(resultSet.getBigDecimal("cost").toString());
                periodicals.add(periodical);
            }
        } catch (SQLException e) {
            LOGGER.error(">>Can't read batch from " + TABLE_NAME, e);
            throw new PersistException(e);
        }
    }

    @Override
    public int getCount() throws PersistException {
        int count = 0;
        String query = "SELECT count(id) FROM " + TABLE_NAME;
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query);
             final ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.error(">>Can't get count from " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return count;
    }

    @Override
    public Periodical getRecordById(final int id) throws PersistException {
        Periodical periodical = null;
        String query = "SELECT id, name, description, issuesPerMonth, cost FROM " + TABLE_NAME + " WHERE id=?";
        ResultSet resultSet = null;
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            statement.setMaxRows(1);
            if (resultSet.next()) {
                periodical = new Periodical();
                periodical.setId(resultSet.getInt("id"));
                periodical.setName(resultSet.getString("name"));
                periodical.setDescription(resultSet.getString("description"));
                periodical.setIssuesPerMonth(resultSet.getInt("issuesPerMonth"));
                periodical.setCost(resultSet.getBigDecimal("cost").toString());
            }
        } catch (SQLException e) {
            LOGGER.error(">>Can't get record from " + TABLE_NAME, e);
            throw new PersistException(e);
        } finally {
            MySqlUtil.closeResultSet(resultSet, TABLE_NAME, LOGGER);
        }
        return periodical;
    }
}
