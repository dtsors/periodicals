package periodicals.filters;

import periodicals.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.PAGE_LOGIN;
import static periodicals.Constants.SESSION_USER;

@WebFilter(filterName = "SubscriberFilter", urlPatterns = {"/add/payment"})
public class SubscriberFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute(SESSION_USER);
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(PAGE_LOGIN);
        }
    }

    @Override
    public void destroy() {

    }
}
