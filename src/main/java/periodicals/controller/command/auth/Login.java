package periodicals.controller.command.auth;

import periodicals.AlertMessage;
import periodicals.HashUtil;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;

public class Login implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(PARAM_EMAIL);
        String password = request.getParameter(PARAM_PASSWORD);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(APPLICATION_DAO);
        UserDao userDao = daoFactory.getUserDao();
        AlertMessage alertMessage;
        try {
            User user = userDao.getRecordByEmail(email);
            if (user != null) {
                if (HashUtil.checkPass(password, user.getPassword())) {
                    request.getSession().setAttribute(SESSION_IS_AUTHORIZED, "true");
                    request.getSession().setAttribute(SESSION_USER, user);
                    alertMessage = AlertMessage.LOGIN_SUCCESSFUL;
                } else {
                    alertMessage = AlertMessage.WRONG_PASSWORD;
                }
            } else {
                alertMessage = AlertMessage.NO_SUCH_USER;
            }
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_FIND_USER, e);
            alertMessage = AlertMessage.DB_ERROR;
        }
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
