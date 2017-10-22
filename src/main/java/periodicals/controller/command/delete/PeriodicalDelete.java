package periodicals.controller.command.delete;

import periodicals.AlertMessage;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.controller.command.CommandUtil;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.*;


public class PeriodicalDelete implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        PeriodicalDao periodicalDao = (PeriodicalDao) request.getServletContext().getAttribute(PERIODICAL_DAO);
        int status = -1;
        try {
            status = periodicalDao.delete(id);
        } catch (PersistException e) {
            LOGGER.error(LOG_CAN_NOT_DELETE_PERIODICAL, e);
        }
        AlertMessage alertMessage = CommandUtil.getMyMessage(status);
        return new CommandResult(PAGE_HOME, alertMessage);
    }
}