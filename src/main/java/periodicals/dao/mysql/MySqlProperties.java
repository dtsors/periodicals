package periodicals.dao.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class MySqlProperties {
    private Properties properties;

    MySqlProperties(final String propertyPath) {
        properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertyPath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
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
