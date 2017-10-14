package periodicals.controller.command.add;

import periodicals.*;
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
import static periodicals.Constants.SESSION_DAO;

public class UserAdd implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String login = request.getParameter(PARAM_LOGIN);
        final String email = request.getParameter(PARAM_EMAIL);
        final String password = request.getParameter(PARAM_PASSWORD);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(SESSION_DAO);
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setLogin(login);
        user.setPassword(HashUtil.hashPassword(password));
        user.setEmail(email);
        user.setRole(Role.SUBSCRIBER.toString());
        int status = -1;
        try {
            status = userDao.create(user);
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_CREATE_USER, e);
        }
        AlertMessage alertMessage;
        if (status > 0) {
            try {
                MailSender.send(new Letter(email).getRegistrationSuccessful(login));
            } catch (MailException e) {
                LOGGER.error(e);
            }
            request.getSession().setAttribute(SESSION_IS_AUTHORIZED, "true");
            request.getSession().setAttribute(SESSION_USER, user);
            alertMessage = AlertMessage.REGISTRATION_SUCCESSFUL;
        } else {
            alertMessage = AlertMessage.REGISTRATION_FAULT;
        }
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
