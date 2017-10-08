package periodicals.controller.command.delete;

import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.entity.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDelete implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        int status = -1;
        try {
            status = userDao.delete(user);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return new CommandResult(SUBSCRIBERS, status);
    }
}
