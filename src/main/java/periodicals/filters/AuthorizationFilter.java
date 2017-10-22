package periodicals.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static periodicals.Constants.PAGE_RESTRICTION;
import static periodicals.Constants.SESSION_IS_AUTHORIZED;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/adduserform.jsp", "/recoverpassword.jsp", "/login.jsp"})
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authorized = (String) httpRequest.getSession().getAttribute(SESSION_IS_AUTHORIZED);
        if ((authorized != null) && ("true".contentEquals(authorized))) {
            httpResponse.sendRedirect(PAGE_RESTRICTION);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
