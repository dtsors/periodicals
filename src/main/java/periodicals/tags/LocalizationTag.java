package periodicals.tags;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class LocalizationTag extends TagSupport {
    @Getter
    @Setter
    private String key;
    private static final Logger logger = Logger.getLogger(LocalizationTag.class);
    private static final ConcurrentHashMap<String, Properties> concurrentHashMap = new ConcurrentHashMap<>();

    public LocalizationTag() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("localization/ru.xml");
            properties.loadFromXML(inputStream);
            concurrentHashMap.put("ru", properties);
        } catch (Exception e) {
            logger.error(">>Can't load russian localization or it has wrong format", e);
        }
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("localization/en.xml");
            properties.loadFromXML(inputStream);
            concurrentHashMap.put("en", properties);
        } catch (Exception e) {
            logger.error(">>Can't load english localization or it has wrong format", e);
        }
    }

    @Override
    public int doStartTag() throws JspException {
        String lang;
        if (pageContext.getSession().isNew()) {
            pageContext.getSession().setAttribute("lang", "en");
            lang = "en";
        } else {
            lang = (String) pageContext.getSession().getAttribute("lang");
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
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
