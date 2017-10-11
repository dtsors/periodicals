package periodicals.controller.command;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    Logger LOGGER = Logger.getLogger(Command.class);

    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}