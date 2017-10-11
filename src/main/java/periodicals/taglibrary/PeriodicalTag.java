package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import static periodicals.Constants.PARAM_ID;
import static periodicals.Constants.SESSION_DAO;

class PeriodicalTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(PeriodicalTag.class);
    private static final String PERIODICAL = "periodical";

    @Override
    public int doStartTag() throws JspException {
        final int id = Integer.parseInt(pageContext.getRequest().getParameter(PARAM_ID));
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute(SESSION_DAO);
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        try {
            Periodical periodical = dao.getRecordById(id);
            pageContext.getRequest().setAttribute(PERIODICAL, periodical);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
