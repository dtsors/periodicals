package periodicals.taglibrary;

import periodicals.controller.command.CommandResult;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static periodicals.Constants.SESSION_COMMAND_RESULT;

public class AlertTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        CommandResult result = (CommandResult) pageContext.getSession().getAttribute(SESSION_COMMAND_RESULT);
        JspWriter writer = pageContext.getOut();
        if ((result != null) && (!"".contentEquals(result.getType()))) {
            try {
                writer.print("<div class='container'>\n" +
                        "    <div class='alert " + result.getType() + " alert-dismissible'>\n" +
                        "        <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>\n" +
                        "        <strong>" + result.getMessage() + "</strong>\n" +
                        "    </div>\n" +
                        "</div>");
            } catch (IOException ignored) {
            }
            pageContext.getSession().setAttribute(SESSION_COMMAND_RESULT, null);
        }
        return SKIP_BODY;
    }
}
