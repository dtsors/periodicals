package periodicals.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LanguageFilter", urlPatterns = {"*.jsp"})
public class LanguageFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String lang = req.getParameter("lang");
        if (httpRequest.getSession().getAttribute("lang") == null){
            httpRequest.getSession().setAttribute("lang", "en");
        }
        if (lang != null) {
            httpRequest.getSession().setAttribute("lang", lang);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
