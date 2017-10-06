package periodicals.model.dao.mysql;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

class MySqlProperties {
    private static final Logger logger = Logger.getLogger(MySqlProperties.class);
    private static final Properties properties = new Properties();

    MySqlProperties() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.xml");
            properties.loadFromXML(inputStream);
        } catch (Exception e) {
            logger.error(">>Can't load MySQL connection settings", e);
        }
    }

    String getUser() {
        return properties.getProperty("user");
    }

    String getPassword() {
        return properties.getProperty("password");
    }

    String getUrl() {
        return properties.getProperty("url");
    }

    String getDriver() {
        return properties.getProperty("driver");
    }
}
