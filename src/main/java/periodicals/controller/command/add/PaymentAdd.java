package periodicals.controller.command.add;

import periodicals.MailSender;
import periodicals.controller.command.Command;
import periodicals.controller.command.CommandResult;
import periodicals.model.entity.Letter;
import periodicals.model.entity.Order;
import periodicals.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static periodicals.Constants.*;

public class PaymentAdd implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        String address = request.getParameter(PARAM_ADDRESS);
        StringBuilder orderMessage = new StringBuilder("Your order is:\r\n");
        if ((session.getAttribute(SESSION_ORDER) != null) &&(session.getAttribute(SESSION_USER) != null)) {
            ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute(SESSION_ORDER);
            for (Order order : orderList) {
                orderMessage.append(order.toString() + "\r\n");
            }
            User user = (User) session.getAttribute(SESSION_USER);
            MailSender.send(new Letter(user.getEmail()).getOrder(orderMessage.toString()));
            session.removeAttribute(SESSION_ORDER);
            return new CommandResult(PAGE_HOME, STATUS_SUCCESS, MSG_CHECK_MAIL);
        }
        return new CommandResult(PAGE_HOME, STATUS_WARNING, MSG_BUSKET_IS_EMPTY);
    }
}
