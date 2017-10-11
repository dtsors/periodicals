package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.listeners.ApplicationListener;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static periodicals.Constants.SESSION_DAO;

public class PeriodicalsTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(PeriodicalsTag.class);
    private static final String PERIODICALSLIST = "periodicalList";

    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute(SESSION_DAO);
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        try {
            List<Periodical> periodicals = dao.getAllRecords();
            pageContext.getRequest().setAttribute(PERIODICALSLIST, periodicals);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
