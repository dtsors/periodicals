package periodicals.controller.command.edit;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;

public class PeriodicalEdit implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        final String name = request.getParameter(PARAM_NAME);
        final String description = request.getParameter(PARAM_DESCRIPTION);
        final int issuesPerMonth = Integer.parseInt(request.getParameter(PARAM_ISSUES_PER_MONTH));
        final String cost = request.getParameter(PARAM_COST);
        DaoFactory daoFactory = (DaoFactory) request.getServletContext().getAttribute(SESSION_DAO);
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        int status = -1;
        try {
            Periodical periodical = periodicalDao.getRecordById(id);
            periodical.setName(name);
            periodical.setDescription(description);
            periodical.setIssuesPerMonth(issuesPerMonth);
            periodical.setCost(cost);
            status = periodicalDao.update(periodical);
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_UPDATE_USER, e);
        }
        AlertMessage alertMessage = CommandUtil.getMyMessage(status);
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
