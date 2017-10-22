package periodicals.controller.command.edit;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;


public class UserEdit implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        final String login = request.getParameter(PARAM_LOGIN);
        UserDao userDao = (UserDao) request.getServletContext().getAttribute(USER_DAO);
        int status = -1;
        try {
            User user = userDao.getRecordById(id);
            user.setLogin(login);
            status = userDao.update(user);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        AlertMessage alertMessage = CommandUtil.getMyMessage(status);
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
