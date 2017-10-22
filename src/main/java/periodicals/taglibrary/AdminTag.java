package periodicals.taglibrary;

import periodicals.Role;
import periodicals.model.entity.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

import static periodicals.Constants.SESSION_IS_AUTHORIZED;
import static periodicals.Constants.SESSION_USER;

public class AdminTag extends BodyTagSupport {
    @Override
    public int doEndTag() throws JspException {
        String authorized = (String) pageContext.getSession().getAttribute(SESSION_IS_AUTHORIZED);
        boolean admin;
        if ((authorized != null) && ("true".contentEquals(authorized))) {
            User user = (User) pageContext.getSession().getAttribute(SESSION_USER);
            admin = Role.ADMIN.toString().contentEquals(user.getRole());
            if (admin) {
                try {
                    JspWriter writer = pageContext.getOut();
                    writer.print(getBodyContent().getString());
                } catch (IOException ignored) {
                }
            }
        }
        return SKIP_BODY;
    }
}
