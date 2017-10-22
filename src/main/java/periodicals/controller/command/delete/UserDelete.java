package periodicals.controller.command.delete;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;

public class UserDelete implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        UserDao userDao = (UserDao) request.getServletContext().getAttribute(USER_DAO);
        int status = -1;
        try {
            status = userDao.delete(id);
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_DELETE_USER, e);
        }
        AlertMessage alertMessage = CommandUtil.getMyMessage(status);
        return new CommandResult(PAGE_SUBSCRIBERS, alertMessage);
    }
}
