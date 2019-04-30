<%@ page import="java.util.List" %>
<%@ page import="demo.Book" %>
<%@page import="Servlet.FindServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: Guo Shu Song
  Date: 2019/4/28
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书 查询</title>
</head>
<body>
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="5">
            <h2>所有图书信息</h2>
        </td>
    </tr>
    <tr align="center">
        <td><b>ID</b></td>
        <td><b>图书名称</b></td>
        <td><b>价  格</b></td>
        <td><b>数  量</b></td>
        <td><b>作  者</b></td>
    </tr>
    <%
        //获取图书信息集合
        List<Book> list = (List<Book>) request.getAttribute("list");
        if (list == null || list.size() < 1) {
            out.print("很抱歉,没有数据!");
        }else {
            for (Book book : list) {
    %>
    <tr align="center">
        <td><%=book.getId()%></td>
        <td><%=book.getName()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getBookCount()%></td>
        <td><%=book.getAuthor()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
