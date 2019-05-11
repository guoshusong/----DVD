<%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/29
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书添加</title>
</head>
<body>
<form action="AddBook.jsp" method="post" onsubmit="return checkbox(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" cosplan="1"></td>
            <h2 align="center">图书信息添加</h2>
        </tr>
        <tr>
            <td align="right">图书编号</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td align="right">图书名称</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td align="right">价  格:</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td align="right">数  量:</td>
            <td><input type="text" name="bookCount"/></td>
        </tr>
        <tr>
            <td align="right">作  者:</td>
            <td><input type="text" name="author"/></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="添 加">
            </td>
        </tr>

    </table>
    <div align="center">
        <a href="main.jsp">返回功能界面</a>
    </div>
</form>
</body>
</html>
