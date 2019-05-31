package Servlet;

import demo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletUserRegister",urlPatterns = "/ServletUserRegister")
public class ServletUserRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");
        String str = "";
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
            //数据库用户名
            String username = "root";
            //数据库密码
            String password = "shumaosha2";
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "INSERT INTO user (userName,userPassword,userEmail) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,userPassword);
            ps.setString(3,userEmail);
            ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
