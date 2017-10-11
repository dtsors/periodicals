package periodicals.controller.command;

import periodicals.AlertMessage;
import periodicals.controller.command.add.OrderAdd;
import periodicals.controller.command.add.PaymentAdd;
import periodicals.controller.command.add.PeriodicalAdd;
import periodicals.controller.command.add.UserAdd;
import periodicals.controller.command.auth.Login;
import periodicals.controller.command.auth.Logout;
import periodicals.controller.command.auth.PasswordRecover;
import periodicals.controller.command.auth.PasswordRenew;
import periodicals.controller.command.delete.PeriodicalDelete;
import periodicals.controller.command.delete.UserDelete;
import periodicals.controller.command.edit.PeriodicalEdit;
import periodicals.controller.command.edit.UserEdit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static periodicals.Constants.PAGE_ERROR;

public class CommandFactory {
    private static final Map<String, Command> commands = new ConcurrentHashMap<>();
    private static final CommandError commandError = new CommandError();

    static {
        commands.put("/add/user", new UserAdd());
        commands.put("/add/periodical", new PeriodicalAdd());
        commands.put("/add/order", new OrderAdd());
        commands.put("/add/payment", new PaymentAdd());
        commands.put("/edit/user", new UserEdit());
        commands.put("/edit/periodical", new PeriodicalEdit());
        commands.put("/delete/user", new UserDelete());
        commands.put("/delete/periodical", new PeriodicalDelete());
        commands.put("/login", new Login());
        commands.put("/logout", new Logout());
        commands.put("/recover", new PasswordRecover());
        commands.put("/renew", new PasswordRenew());
    }

    public static Command getCommand(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getRequestURI();
        if (commands.containsKey(key)) {
            return commands.get(key);
        } else {
            return commandError;
        }
    }
}

class CommandError implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new CommandResult(PAGE_ERROR, AlertMessage.EMPTY);
    }
}
