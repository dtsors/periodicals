package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.Constants;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static periodicals.Constants.USER_DAO;

public class UserListTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(UserListTag.class);

    @Override
    public int doStartTag() throws JspException {
        UserDao dao = (UserDao) pageContext.getServletContext().getAttribute(USER_DAO);
        try {
            List<User> users = dao.getAllRecords();
            pageContext.getRequest().setAttribute(Constants.TAG_USERS_LIST, users);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
