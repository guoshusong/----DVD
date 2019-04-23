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
    String name = request.getParameter("name");
    session.setAttribute("name",name);
%>
<div align="center">
    <form id="form1" method="post" action="result.jsp">
        <table width="28%" border="0">
            <tr>
                <td>你的名字:</td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>你的爱好</td>
                <td>
                    <label>
                        <input type="text" name="address">
                    </label>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
