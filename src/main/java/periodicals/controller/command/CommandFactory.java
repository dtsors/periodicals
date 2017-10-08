package periodicals.controller.command;

import org.apache.log4j.Logger;
import periodicals.controller.command.add.PeriodicalAdd;
import periodicals.controller.command.add.UserAdd;
import periodicals.controller.command.delete.PeriodicalDelete;
import periodicals.controller.command.delete.UserDelete;
import periodicals.controller.command.edit.PeriodicalEdit;
import periodicals.controller.command.edit.UserEdit;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandFactory {
    private static final Logger logger = Logger.getLogger(CommandFactory.class);
    private static Map<String, Command> commands = new ConcurrentHashMap<>();

    static {
        commands.put("/add/user", new UserAdd());
        commands.put("/add/periodical", new PeriodicalAdd());
        commands.put("/edit/user", new UserEdit());
        commands.put("/edit/periodical", new PeriodicalEdit());
        commands.put("/delete/user", new UserDelete());
        commands.put("/delete/periodical", new PeriodicalDelete());
        commands.put("null", new CommandError());
    }

    public static Command getCommand(HttpServletRequest req) {
        String key = req.getRequestURI();
        Command command = commands.get(key);
        if (command == null) {
            command = commands.get("null");
        }
        return command;
    }
}
