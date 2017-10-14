package periodicals.controller.command.auth;

import periodicals.AlertMessage;
import periodicals.MailException;
import periodicals.MailSender;
import periodicals.HashUtil;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Letter;
import periodicals.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;

public class PasswordRenew implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String token = request.getParameter(PARAM_TOKEN);
        final String password = request.getParameter(PARAM_PASSWORD);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(SESSION_DAO);
        UserDao userDao = daoFactory.getUserDao();
        AlertMessage alertMessage = AlertMessage.PASSWORD_CHANGED;
        try {
            User user = userDao.getRecordByToken(token);
            if (user != null) {
                user.setPassword(HashUtil.hashPassword(password));
                user.setToken("");
                userDao.update(user);
                MailSender.send(new Letter(user.getEmail()).getPasswordChanged());
            } else {
                alertMessage = AlertMessage.WRONG_TOKEN;
            }
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_FIND_USER, e);
            alertMessage = AlertMessage.DB_ERROR;
        } catch (MailException e) {
            LOGGER.error(e);
        }
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
