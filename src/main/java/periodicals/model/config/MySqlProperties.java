package periodicals.model.config;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class MySqlProperties {
    private static final Logger LOGGER = Logger.getLogger(MySqlProperties.class);
    private static final Properties properties = new Properties();

    public MySqlProperties() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.xml");
            properties.loadFromXML(inputStream);
        } catch (Exception e) {
            LOGGER.error(">>Can't load MySQL connection settings", e);
        }
    }

    public String getUser() {
        return properties.getProperty("user");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public String getCachePrepStmts() {
        return properties.getProperty("cachePrepStmts");
    }

    public String getPrepStmtCacheSize() {
        return properties.getProperty("prepStmtCacheSize");
    }

    public String getPrepStmtCacheSqlLimit() {
        return properties.getProperty("prepStmtCacheSqlLimit");
    }
}
