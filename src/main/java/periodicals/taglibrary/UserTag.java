package periodicals.taglibrary;

import periodicals.model.entity.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

class UserTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        DaoFactory daoFactory = (DaoFactory) pageContext.getServletContext().getAttribute("periodicals.model");
        UserDao dao = daoFactory.getUserDao();
        try {
            final int id = Integer.parseInt(pageContext.getRequest().getParameter("id"));
            User user = dao.getRecordById(id);
            pageContext.getRequest().setAttribute("user", user);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
