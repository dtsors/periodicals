package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static periodicals.Constants.*;

public class PeriodicalListTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(PeriodicalListTag.class);

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        PeriodicalDao dao = (PeriodicalDao) pageContext.getServletContext().getAttribute(PERIODICAL_DAO);
        int page = 0;
        try {
            page = Integer.parseInt(request.getParameter(PARAM_PAGE)) - 1;
        } catch (Exception ignored) {
        }

        try {
            List<Periodical> periodicals = dao.getAllRecords(page * PAGINATION_COUNT, PAGINATION_COUNT);
            pageContext.getRequest().setAttribute(TAG_PERIODICALS_LIST, periodicals);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
