package periodicals.controller.command;

import lombok.Getter;
import periodicals.AlertMessage;

@Getter
public class CommandResult {
    String path;
    String message;
    String type;

    public CommandResult(String path, String type, String message) {
        this.path = path;
        this.type = type;
        this.message = message;
    }

    public CommandResult(String path, AlertMessage alertMessage) {
        this.path = path;
        this.type = alertMessage.getType();
        this.message = alertMessage.getMessage();
    }
}
