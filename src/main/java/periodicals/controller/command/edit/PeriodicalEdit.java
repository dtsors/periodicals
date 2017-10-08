package periodicals.controller.command.edit;

import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.entity.Periodical;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PeriodicalEdit implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        Periodical periodical = new Periodical();
        periodical.setId(Integer.parseInt(req.getParameter("id")));
        periodical.setName(req.getParameter("name"));
        periodical.setDescription(req.getParameter("description"));
        periodical.setIssuesPerMonth(Integer.parseInt(req.getParameter("issuesPerMonth")));
        periodical.setCost(req.getParameter("cost"));
        int status = -1;
        try {
            status = periodicalDao.update(periodical);
        } catch (PersistException e) {
            LOGGER.error(e);
        }
        return new CommandResult(HOME_PAGE, status);
    }
}
