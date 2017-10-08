package periodicals.taglibrary;

import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.entity.Periodical;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class PeriodicalsTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao dao = daoFactory.getPeriodicalDao();
        try {
            List<Periodical> periodicals = dao.getAllRecords();
            pageContext.getRequest().setAttribute("periodicalslist", periodicals);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
