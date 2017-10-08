package periodicals.taglibrary;

import periodicals.model.entity.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class UsersTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute("periodicals.model");
        UserDao dao = daoFactory.getUserDao();
        try {
            List<User> users = dao.getAllRecords();
            pageContext.getRequest().setAttribute("userslist", users);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
