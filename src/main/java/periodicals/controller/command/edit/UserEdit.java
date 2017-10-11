package periodicals.controller.command.edit;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.entity.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;
import static periodicals.Constants.PARAM_ID;
import static periodicals.Constants.SESSION_DAO;


public class UserEdit implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        final String login = request.getParameter(PARAM_LOGIN);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(SESSION_DAO);
        UserDao userDao = daoFactory.getUserDao();
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
