package periodicals.model.dao.mysql;

import org.apache.log4j.Logger;
import periodicals.model.dao.UserDao;
import periodicals.model.entity.User;
import periodicals.model.dao.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDao {
//    private static final Logger LOGGER = Logger.getLogger(MySqlUserDao.class);
    private static final String TABLE_NAME = "users";

    @Override
    public int save(final User user) throws PersistException {
        int status;
        final String query = "INSERT INTO " + TABLE_NAME + "(login,password,email) VALUES(?,?,?)";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't insert in " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int update(final User user) throws PersistException {
        int status;
        final String query = "UPDATE " + TABLE_NAME + " SET login=?,password=?,email=? WHERE id=?";
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't update " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public int delete(final User user) throws PersistException {
        int status;
        try (Connection connection = MySqlCP.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE id=?")) {
            statement.setInt(1, user.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(">>Can't delete from " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return status;
    }

    @Override
    public List<User> getAllRecords() throws PersistException {
        List<User> users = new ArrayList<>();
        final String query = "SELECT * FROM " + TABLE_NAME;
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query);
             final ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error(">>Can't read batch from " + TABLE_NAME, e);
            throw new PersistException(e);
        }
        return users;
    }

    @Override
    public User getRecordById(final int id) throws PersistException {
        User user = null;
        final String query = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
        ResultSet resultSet = null;
        try (final Connection connection = MySqlCP.getInstance().getConnection();
             final PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            statement.setMaxRows(1);
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        } finally {
            MySqlUtil.closeResultSet(resultSet, TABLE_NAME, LOGGER);
        }
        return user;
    }
}
