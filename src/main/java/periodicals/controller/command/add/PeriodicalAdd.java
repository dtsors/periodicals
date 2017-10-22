package periodicals.controller.command.add;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;
import periodicals.model.entity.Periodical;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;

public class PeriodicalAdd implements Command{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter(PARAM_NAME);
        final String description = request.getParameter(PARAM_DESCRIPTION);
        final int issuesPerMonth = Integer.parseInt(request.getParameter(PARAM_ISSUES_PER_MONTH));
        final String cost = request.getParameter(PARAM_COST);
        PeriodicalDao periodicalDao = (PeriodicalDao) request.getServletContext().getAttribute(PERIODICAL_DAO);
        Periodical periodical = new Periodical();
        periodical.setName(name);
        periodical.setDescription(description);
        periodical.setIssuesPerMonth(issuesPerMonth);
        periodical.setCost(cost);
        int status = -1;
        try {
            status = periodicalDao.create(periodical);
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_CREATE_PERIODICAL, e);
        }
        AlertMessage alertMessage = CommandUtil.getMyMessage(status);
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}
