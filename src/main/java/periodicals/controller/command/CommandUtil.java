package periodicals.controller.command;

import periodicals.AlertMessage;

public class CommandUtil {
    private CommandUtil() {
    }

    public static AlertMessage getMyMessage(int status) {
        AlertMessage alertMessage;
        if (status < 0) {
            alertMessage = AlertMessage.DB_ERROR;
        } else {
            alertMessage = AlertMessage.EMPTY;
        }
        return alertMessage;
    }
}
