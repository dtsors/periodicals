package periodicals.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static periodicals.Constants.*;

@WebFilter(filterName = "LanguageFilter", urlPatterns = {"/add/*", "/edit/*", "/delete/*", "*.jsp"})
public class LanguageFilter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String lang = request.getParameter(PARAM_LANG);
        if (httpRequest.getSession().getAttribute(SESSION_LANGUAGE) == null){
            httpRequest.getSession().setAttribute(SESSION_LANGUAGE, ENGLISH);
        }
        if (lang != null) {
            httpRequest.getSession().setAttribute(SESSION_LANGUAGE, lang);
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
