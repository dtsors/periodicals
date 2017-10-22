package periodicals.taglibrary;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static periodicals.Constants.SESSION_IS_AUTHORIZED;

public class AuthorizedTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {

        String authorized = (String) pageContext.getSession().getAttribute(SESSION_IS_AUTHORIZED);
        JspWriter writer = pageContext.getOut();
        try {
            if ((authorized == null) || ("false".contentEquals(authorized))) {
                writer.print("<li class='nav-item'><a class='nav-link text-light' href='adduserform.jsp'>Registration</a></li>" +
                        "<li><a class='nav-link text-light' href='recoverpassword.jsp'>Recover</a></li>" +
                        "<li><a class='nav-link text-light' href='login.jsp'>SignIn</a></li>");
            } else {
                writer.print("<li><a class='nav-link text-light' href='logout'>SignOut</a></li>");
            }
        } catch (IOException ignored) {
        }
        return SKIP_BODY;
    }
}
