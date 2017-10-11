package periodicals.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static periodicals.Constants.CHARACTER_ENCODING;
import static periodicals.Constants.CONTENT_TYPE;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/add/*", "/edit/*", "/delete/*", "*.jsp"})
public class EncodingFilter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
