package Servlet;

import sql.SqlConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "FindPassword",urlPatterns = "/FindPassword")
public class FindPassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        try {
            SqlConnection sqlConnection = new SqlConnection();
            Connection connection =sqlConnection.getConnection();
            String sql = "SELCET FROM user WHERE userName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
