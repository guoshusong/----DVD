<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/17
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="GB18030">
    <title>结果页</title>
</head>
<body>
<%
    String user = request.getParameter("user");
    Date Mydate = new Date();
    SimpleDateFormat dtf = new SimpleDateFormat("h:m:s");
    Cookie Mycookie = new Cookie("mrCookie",user + "#" +dtf.format(Mydate));
    Mycookie.setMaxAge(60*60*24*30);//设置cookie的有效期位30天
    response.addCookie(Mycookie);
%>
<a href="index.jsp">返回</a>
</body>
</html>
