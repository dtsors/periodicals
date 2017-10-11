package periodicals.controller.command.auth;

import periodicals.AlertMessage;
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

public class PasswordRecover implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(PARAM_EMAIL);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(SESSION_DAO);
        UserDao userDao = daoFactory.getUserDao();
        AlertMessage alertMessage;
        try {
            User user = userDao.getRecordByEmail(email);
            if (user != null) {
                String token = HashUtil.getRandomUuid();
                user.setToken(token);
                userDao.update(user);
                MailSender.send(new Letter(user.getEmail()).getPasswordRecovery(token));
                alertMessage = AlertMessage.CHECK_MAIL;
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
