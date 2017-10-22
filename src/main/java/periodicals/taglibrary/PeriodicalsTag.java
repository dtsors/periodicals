package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static periodicals.Constants.*;

public class PeriodicalsTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(PeriodicalsTag.class);
    private static final String PERIODICALSLIST = "periodicalList";

    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute(APPLICATION_DAO);
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        int page = 0;
        try {
            page = Integer.parseInt(request.getParameter(PARAM_PAGE)) - 1;
        } catch (Exception e) {
        }

        try {
            List<Periodical> periodicals = dao.getAllRecords(page * PAGINATION_COUNT, PAGINATION_COUNT);
            pageContext.getRequest().setAttribute(PERIODICALSLIST, periodicals);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
