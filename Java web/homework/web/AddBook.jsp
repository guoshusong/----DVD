<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/28
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="book" class="demo.Book"></jsp:useBean>
<jsp:setProperty name="book" property="*"/>
<%
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
        String sql = "insert into book(name,price,bookCount,author,id) values(?,?,?,?,?)";
        PreparedStatement ps  = conn.prepareStatement(sql);
        ps.setString(1,book.getName());
        ps.setDouble(2,book.getPrice());
        ps.setInt(3,book.getBookCount());
        ps.setString(4,book.getAuthor());
        ps.setInt(5,book.getId());
        //执行更新操作
        int row = ps.executeUpdate();
        if (row > 0) {
            out.print("成功添加了" + row + "本图书");
        }
    }catch (Exception e){
        out.print("图书信息添加失败");
        e.printStackTrace();
    }
%>
<div align="center">
    <a href="BookAdd.jsp">返回</a>
</div>
</body>
</html>
