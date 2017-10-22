package periodicals.controller.command.add;

import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static periodicals.Constants.*;

public class OrderAdd implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id = Integer.parseInt(request.getParameter(PARAM_ID));
        final int count = Integer.parseInt(request.getParameter(PARAM_COUNT));
        HttpSession session = request.getSession();
        Order order = Order.builder().periodicalId(id).count(count).build();
        if (session.getAttribute(SESSION_ORDER) == null) {
            ArrayList<Order> arrayList = new ArrayList<>();
            arrayList.add(order);
            session.setAttribute(SESSION_ORDER, arrayList);
        } else {
            ArrayList<Order> arrayList = (ArrayList<Order>) session.getAttribute(SESSION_ORDER);//TODO
            arrayList.add(order);
        }
        final String message = "Item has been added";
        return new CommandResult(PAGE_HOME, STATUS_INFO, message);
    }
}
