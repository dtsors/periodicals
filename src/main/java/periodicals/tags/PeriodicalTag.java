package periodicals.tags;

import periodicals.domain.Periodical;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

class PeriodicalTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        try {
            final int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
            Periodical periodical = dao.getRecordById(id);
            pageContext.getRequest().setAttribute("periodical", periodical);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
