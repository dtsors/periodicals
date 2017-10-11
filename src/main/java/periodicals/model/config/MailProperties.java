package periodicals.model.config;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class MailProperties {
    private static final Logger LOGGER = Logger.getLogger(MailProperties.class);
    private static final Properties properties = new Properties();

    public MailProperties() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mail.xml");
            properties.loadFromXML(inputStream);
        } catch (Exception e) {
            LOGGER.error(">>Can't load Mail settings", e);
        }
    }

    public static String getSmtpHostname() {
        return properties.getProperty("smtp_hostname");
    }

    public static int getSmtpPort() {
        int port = 465;
        try {
            port = Integer.parseInt(properties.getProperty("smtp_port"));
        } catch (NumberFormatException e) {
            LOGGER.error("Wrong smtp_port value, using " + port + " instead", e);
        }
        return port;
    }

    public static String getUserName() {
        return properties.getProperty("user_name");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static int getMailingThreads() {
        int threads = 2;
        try {
            threads = Integer.parseInt(properties.getProperty("mailing_threads"));
        } catch (NumberFormatException e) {
            LOGGER.error("Wrong mailing_threads value, using " + threads + " instead", e);
        }
        return threads;
    }
}
