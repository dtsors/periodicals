package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import static periodicals.Constants.*;

public class PeriodicalTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(PeriodicalTag.class);

    @Override
    public int doStartTag() throws JspException {
        final int id = Integer.parseInt(pageContext.getRequest().getParameter(PARAM_ID));
        PeriodicalDao dao = (PeriodicalDao) pageContext.getServletContext().getAttribute(PERIODICAL_DAO);
        try {
            Periodical periodical = dao.getRecordById(id);
            pageContext.getRequest().setAttribute(TAG_PERIODICAL, periodical);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
