import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter extends HttpServlet implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String local = request.getLocalName();
        String userName = request.getParameter("userName");
        if ( session.getAttribute("userName") == null ) {
                response.sendRedirect("login.jsp");
        }
        chain.doFilter(req, resp);

    }
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
