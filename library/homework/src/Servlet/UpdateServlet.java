package Servlet;

import demo.Book;
import sql.SqlConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        int bookCount = Integer.valueOf(request.getParameter("bookCount"));
        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
            //数据库用户名
            String username = "root";
            //数据库密码
            String password = "shumaosha2";
            Connection conn = DriverManager.getConnection(url,username,password);
            //SqlConnection connection  = new SqlConnection();
            //Connection conn = connection.getConnection();
            String sql = "update book set bookcount=? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bookCount);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();
            conn.close();
            //connection.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("FindServlet");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
