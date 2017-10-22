package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

import static periodicals.Constants.APPLICATION_DAO;

public class UsersTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(UsersTag.class);
    private static final String USERSLIST = "userList";

    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute(APPLICATION_DAO);
        UserDao dao = daoFactory.getUserDao();
        try {
            List<User> users = dao.getAllRecords();
            pageContext.getRequest().setAttribute(USERSLIST, users);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
