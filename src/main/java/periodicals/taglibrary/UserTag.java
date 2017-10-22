package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.Constants;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import static periodicals.Constants.PARAM_ID;
import static periodicals.Constants.USER_DAO;

public class UserTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(UserTag.class);

    @Override
    public int doStartTag() throws JspException {
        UserDao dao = (UserDao) pageContext.getServletContext().getAttribute(USER_DAO);
        try {
            final int id = Integer.parseInt(pageContext.getRequest().getParameter(PARAM_ID));
            User user = dao.getRecordById(id);
            pageContext.getRequest().setAttribute(Constants.TAG_USER, user);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
