<%@ page import="java.util.Enumeration" %>
<%@page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/4/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="GB18030" http-equiv="Refresh" content="1">
    <title>第一个web应用</title>
      <style type="text/css">
          #clock{
              width: 500px;
              height: 80px;
              background: aqua;
              font-size: 25px;
              font-weight: bold;
              border: solid 5px orange;
              padding: 20px;
          }
          #week{
              padding-top: 15px;
              color: darkmagenta;
          }
      </style>
  </head>
  <body>
    <jsp:useBean id="date" class="com.bean.DateBean" scope="application"></jsp:useBean>
    <div align="center">
        <div id="clock">
            <div id="time">
                <jsp:getProperty name="date" property="dateTime"/>
            </div>
            <div id="week">
                <jsp:getProperty name="date" property="week"/>
            </div>
        </div>
    </div>
  </body>
</html>
