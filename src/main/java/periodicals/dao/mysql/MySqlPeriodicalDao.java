package periodicals.dao.mysql;

import periodicals.dao.PeriodicalDao;
import periodicals.domain.Periodical;
import periodicals.dao.PersistException;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPeriodicalDao implements PeriodicalDao {
    @Override
    public int save(final Periodical periodical) throws PersistException {
        int status;
        String query = "INSERT INTO periodicals(name, description, issuesPerMonth, cost) VALUES(?,?,?,?)";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, periodical.getName());
            statement.setString(2, periodical.getDescription());
            statement.setInt(3, periodical.getIssuesPerMonth());
            statement.setBigDecimal(4, new BigDecimal(periodical.getCost()));
            status = statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int update(final Periodical periodical) throws PersistException {
        int status;
        String query = "UPDATE periodicals SET name=?,description=?,issuesPerMonth=?,cost=? WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, periodical.getName());
            statement.setString(2, periodical.getDescription());
            statement.setInt(3, periodical.getIssuesPerMonth());
            statement.setBigDecimal(4, new BigDecimal(periodical.getCost()));
            statement.setInt(5, periodical.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int delete(final Periodical periodical) throws PersistException {
        int status;
        String query = "DELETE FROM periodicals WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, periodical.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public List<Periodical> getAllRecords() throws PersistException {
        List<Periodical> periodicals = new ArrayList<>();
        String query = "SELECT * FROM periodicals";
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
            throw new PersistException(e);
        }
        return periodicals;
    }

    @Override
    public Periodical getRecordById(final int id) throws PersistException {
        Periodical periodical = null;
        String query = "SELECT * FROM periodicals WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query);
             final ResultSet resultSet = statement.executeQuery()) {
            statement.setInt(1, id);
            statement.setMaxRows(1);
            if (resultSet.next()) {
                periodical = new Periodical();
                periodical.setId(resultSet.getInt("id"));
                periodical.setDescription(resultSet.getString("description"));
                periodical.setIssuesPerMonth(resultSet.getInt("issuesPerMonth"));
                periodical.setCost(resultSet.getBigDecimal("cost").toString());
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return periodical;
    }
}
