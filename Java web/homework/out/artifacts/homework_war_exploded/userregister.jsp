<%--
  Created by IntelliJ IDEA.
  User: ChaoMeng
  Date: 2019/5/5
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ServletUserRegister" method="post">
        <table align = "center" border="1" style="border-collapse: collapse;">
            <tr align="center">
                <td colspan="2">用户注册</td>
            <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" /></td>
        </tr>
            <tr>
               <td>密码：</td>
                <td><input type="password" name="userPassword" /></td>
            </tr> <tr>
               <td class="tdstyle" colspan="2" align="center">
                      <input type="submit" value="注册" />
                       </td>
                     </tr>
                     </table>
           </form>
</body>
</html>
