package periodicals.controller.command.add;

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

public class UserAdd implements Command{
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        int status = -1;
        try {
            status = userDao.save(user);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return new CommandResult(HOME_PAGE, status);
    }
}
