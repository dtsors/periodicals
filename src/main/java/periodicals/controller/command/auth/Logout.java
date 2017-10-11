package periodicals.controller.command.auth;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.PAGE_HOME;
import static periodicals.Constants.SESSION_IS_AUTHORIZED;
import static periodicals.Constants.SESSION_USER;

public class Logout implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute(SESSION_IS_AUTHORIZED);
        request.getSession().removeAttribute(SESSION_USER);
        return new CommandResult(PAGE_HOME, AlertMessage.LOGOUT);
    }
}
