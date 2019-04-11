package Sql01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conn {
    java.sql.Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql:"+"//localhost:3306/test?serverTimezone=UTC","root","shumaosha2");
            System.out.println("数据库链接成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Conn c = new Conn();
        c.getConnection();
    }
}
