import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class CountFilter implements Filter {
    private int count;
    @Override
    public void init(FilterConfig filterConfig)throws ServletException{
        //获取初始化参数
        String param = filterConfig.getInitParameter("count");
        //将字符串初始化为int
        count = Integer.valueOf(param);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException,ServletException {
        //访问量自增
        count++;
        //将ServletRequest转换成HttpServletRequest
        HttpServletRequest req = (HttpServletRequest)request;
        //获取ServletContext
        ServletContext context = req.getSession().getServletContext();
        //将来访数量值放入ServletContext中
        context.setAttribute("count",count);
        chain.doFilter(request,response);
    }
    @Override
    public void destroy(){
    }
}
