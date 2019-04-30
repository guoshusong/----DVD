package Servlet;

/**
 * Created by IntelliJ IDEA.
 * Author: Guo Shu Song
 * Date: 2019/4/28
 * Time: 22:40
 * */

import demo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FindServlet",urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        //加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //数据库连接字符串
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=true";
        //数据库用户名
        String username = "root";
        //数据库密码
        String password = "shumaosha2";
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        String sql = "select *from book";
        ResultSet rs = stmt.executeQuery(sql);
        //实例化List对象
        List<Book> list = new ArrayList<Book>();
        //光标向后移，并判断是否有效
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setBookCount(rs.getInt("bookCount"));
            book.setPrice(rs.getDouble("price"));
            book.setAuthor(rs.getString("author"));
            list.add(book);
        }
        request.setAttribute("list",list);
        rs.close();
        stmt.close();
        conn.close();
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }catch (SQLException e){
        e.printStackTrace();
    }
    //转发请求至 book_list.jsp
    request.getRequestDispatcher("book_list.jsp").forward(request,response);
    }
}
