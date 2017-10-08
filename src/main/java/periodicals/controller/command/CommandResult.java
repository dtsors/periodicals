package periodicals.controller.command;

import lombok.Getter;

@Getter
public class CommandResult {
    String Path;
    int status;

    public CommandResult(String path, int status) {
        Path = path;
        this.status = status;
    }
}
