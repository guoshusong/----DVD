package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author : Guo Shu Song
 * Date : 2019 - 5 - 11
 * */

public class SqlConnection {
    private String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private String userName = "root";
    private String userPassword = "shumaosha2";
    private Connection conn;
    public void DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,userName,userPassword);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void closeConnection(){
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
