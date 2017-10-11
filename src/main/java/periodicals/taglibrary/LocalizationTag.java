package periodicals.taglibrary;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import static periodicals.Constants.*;

public class LocalizationTag extends TagSupport {
    @Getter
    @Setter
    private String key;
    private static final Logger LOGGER = Logger.getLogger(LocalizationTag.class);
    private static final Map<String, Properties> concurrentHashMap = new ConcurrentHashMap<>();

    public LocalizationTag() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("localization/ru.xml");
            properties.loadFromXML(inputStream);
            concurrentHashMap.put(RUSSIAN, properties);
        } catch (Exception e) {
            LOGGER.error(">>Can't load russian localization or it has wrong format", e);
        }
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("localization/en.xml");
            properties.loadFromXML(inputStream);
            concurrentHashMap.put(ENGLISH, properties);
        } catch (Exception e) {
            LOGGER.error(">>Can't load english localization or it has wrong format", e);
        }
    }

    @Override
    public int doStartTag() throws JspException {
        String lang;
        if (pageContext.getSession().isNew()) {
            pageContext.getSession().setAttribute(SESSION_LANGUAGE, ENGLISH);
            lang = ENGLISH;
        } else {
            lang = (String) pageContext.getSession().getAttribute(SESSION_LANGUAGE);
        }
        String out;
        if (concurrentHashMap.containsKey(lang)) {
            out = concurrentHashMap.get(lang).getProperty(key, key);
        } else {
            out = key;
        }
        try {
            pageContext.getOut().write(out);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
