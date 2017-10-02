package periodicals.tag;

import periodicals.dao.DaoFactory;
import periodicals.dao.PeriodicalDao;
import periodicals.domain.Periodical;
import periodicals.dao.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class PeriodicalsTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute("periodicals.dao");
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        try {
            List<Periodical> periodicals = dao.getAllRecords();
            pageContext.getRequest().setAttribute("list", periodicals);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
