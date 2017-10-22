package periodicals.taglibrary;

import org.apache.log4j.Logger;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import static periodicals.Constants.APPLICATION_DAO;
import static periodicals.Constants.PARAM_ID;

class UserTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(UserTag.class);
    private static final String USER = "user";

    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute(APPLICATION_DAO);
        UserDao dao = daoFactory.getUserDao();
        try {
            final int id = Integer.parseInt(pageContext.getRequest().getParameter(PARAM_ID));
            User user = dao.getRecordById(id);
            pageContext.getRequest().setAttribute(USER, user);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return SKIP_BODY;
    }
}
