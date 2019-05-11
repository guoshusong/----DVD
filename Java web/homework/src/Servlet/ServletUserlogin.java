package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ServletUserlogin",urlPatterns = "/ServletUserlogin")
public class ServletUserlogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
            //数据库用户名
            String username = "root";
            //数据库密码
            String password = "shumaosha2";
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "select * from user where userName = ? and userPassword = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,userPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                response.sendRedirect("main.jsp");
            }else {
                response.sendRedirect("loginFault.jsp");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
