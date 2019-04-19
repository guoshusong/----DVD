<%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.net.URLDecoder" %>
<html>
  <head>
    <meta charset="GB18030">
    <title>第一个web应用</title>
  </head>
  <body>
<%
  Cookie[] cookie = request.getCookies();//从request中获得cookie对象的集合
  String user =" ";//用户姓名
  String date = " ";//注册时间
  if (cookie != null) {
    for (int i = 0; i < cookie.length; i++){
      if (cookie[i].getName().equals("mrCookie")) {
        user = cookie[i].getValue().split("#")[0];//获取用户名
        date = cookie[i].getValue().split("#")[1];//获取注册时间
      }
    }
  }
  if (" ".equals(user)&&" ".equals(date)){
%>
  您好，欢迎初次访问！
  <form action="delete.jsp" method="post">
    请输入姓名:<input name="user" type="text" value="">
    <input type="submit" value="确定">
  </form>
  <%
    }else {
  %>
    欢迎[<b><%=user%><b>]再次光临<br>
  您注册的时间是<%=date%>
  <%
    }
    %>

  </body>
</html>
