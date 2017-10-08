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

@WebServlet(urlPatterns = {"/add/*", "/edit/*", "/delete/*"}, loadOnStartup = 1)
public class PeriodicalServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = CommandFactory.getCommand(req);
        CommandResult commandResult = command.execute(req, resp);
        req.getSession().setAttribute("status", String.valueOf(commandResult.getStatus()));
        resp.sendRedirect(commandResult.getPath());
    }
}
