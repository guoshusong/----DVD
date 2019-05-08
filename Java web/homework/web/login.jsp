<%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/5/5
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="/ServletUserlogin" method="post">
    <table align = "center" border="1" style="border-collapse: collapse;">
        <tr>
            <td colspan="2" align="center">管理员登陆</td>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="userPassword" /></td>
        </tr> <tr>
        <td colspan="2" align="center">
            <input type="submit" value="登陆" />
        </td>
    </tr>
    </table>
</form>
<div align="center">
    <a href="index.jsp">返回登陆注册界面</a>
</div>
</body>
</html>
