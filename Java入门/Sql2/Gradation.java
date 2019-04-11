package Sql2;

import java.awt.*;
import java.sql.*;

public class Gradation {
    static Connection con;
    static Statement sql;
    static ResultSet res;
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
        Gradation c =new Gradation();
        con = c.getConnection();
        try {
            sql = con.createStatement();
            res = sql.executeQuery("select * from tb_stu");
            while (res.next()) {//当前行的初始值为null
                String id = res.getString("id");
                String name = res.getString("name");
                String sex = res.getString("sex");
                System.out.println("编号" + id);
                System.out.println("名字" + name);
                System.out.println("性别 " + sex);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
