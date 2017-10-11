package periodicals.filters;

import periodicals.Role;
import periodicals.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.PAGE_RESTRICTION;
import static periodicals.Constants.SESSION_USER;

@WebFilter(filterName = "AccessFilter", urlPatterns = {"/viewusers.jsp", "/editperiodicalform.jsp", "/delete/periodical"})
public class AccessFilter implements javax.servlet.Filter  {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute(SESSION_USER);
        if ((user != null) && Role.ADMIN.toString().contentEquals(user.getRole())) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(PAGE_RESTRICTION);
        }
    }

    @Override
    public void destroy() {

    }
}
