package periodicals.controller.command.delete;

import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PeriodicalDelete implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        int status = -1;
        try {
            Periodical periodical = new Periodical();
            periodical.setId(Integer.parseInt(req.getParameter("id")));
            status = periodicalDao.delete(periodical);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return new CommandResult(HOME_PAGE, status);
    }
}