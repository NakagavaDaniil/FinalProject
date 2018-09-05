package filtr;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class Authentication implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        if(path.contains("Info")||path.contains(".jsp")) {
            if (request.getSession().getAttribute("userId")!= null) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                servletResponse.getWriter().append("AccessDenied");

            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
