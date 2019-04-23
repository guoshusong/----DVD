<%@ page import="com.bean.Email" %><%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/20
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="GB18030">
    <title>Title</title>
</head>
<body>
<div align="center">
    <%
        //获取邮箱地址
        String maiAdd = request.getParameter("mailAdd");
        //实例化Email，并对mailAdd赋值
        Email email = new Email(maiAdd);
        if (email.isEmail()) {
            out.print(maiAdd + "<br>是一个标准邮箱</br>");
        }else {
            out.print(maiAdd + "<br>不是一个标准邮箱</br>");
        }
    %>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
