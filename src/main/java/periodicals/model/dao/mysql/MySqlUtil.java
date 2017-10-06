package periodicals.model.dao.mysql;

import org.apache.log4j.Logger;
import periodicals.model.dao.exceptions.PersistException;

import java.sql.ResultSet;
import java.sql.SQLException;

class MySqlUtil {
    static void closeResultSet(ResultSet resultSet, String tableName, Logger logger) throws PersistException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(">>Can't close resultSet while using" + tableName, e);
                throw new PersistException(e);
            }
        }
    }
}
