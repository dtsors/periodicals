package periodicals.controller;

import periodicals.controller.command.Command;
import periodicals.controller.command.CommandFactory;
import periodicals.controller.command.CommandResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.SESSION_COMMAND_RESULT;

@WebServlet(urlPatterns = {"/add/*", "/edit/*", "/delete/*", "/login", "/logout", "/recover", "/renew"})
public class RootServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.getCommand(request, response);
        CommandResult commandResult = command.execute(request, response);
        request.getSession().setAttribute(SESSION_COMMAND_RESULT, commandResult);
        response.sendRedirect(commandResult.getPath());
    }
}
