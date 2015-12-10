package util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.xml.ws.ResponseWrapper;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * Created by xdx on 2015/12/10.
 */
@WebFilter(urlPatterns = "/*",
        initParams = @WebInitParam(name = "charset", value = "utf-8"))
public class EncodingFilter implements Filter {
    private String charset;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
