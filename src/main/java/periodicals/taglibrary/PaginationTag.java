package periodicals.taglibrary;

import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static periodicals.Constants.PAGINATION_COUNT;
import static periodicals.Constants.PERIODICAL_DAO;

public class PaginationTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        try {
            PeriodicalDao dao = (PeriodicalDao) pageContext.getServletContext().getAttribute(PERIODICAL_DAO);
            int count = 1;
            try {
                count = (int) Math.ceil((double) dao.getCount() / PAGINATION_COUNT);
            } catch (PersistException ignored) {
            }
            for (int i = 1; i <= Math.floor(count); i++) {
                writer.print("<a href='index.jsp?page=" + i + "'>" + i + "</a> ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
