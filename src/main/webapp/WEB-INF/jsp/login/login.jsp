<%--
  Created by IntelliJ IDEA.
  User: chenxiaoqi
  Date: 2017/7/2
  Time: 下午9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login.action" method="post">
        <label for="name">Name:</label> <input id="name" name="name" type="text">
        <br>
        <label for="password">Password:</label><input id="password" name="password" type="password">
        <br>
        <input name="submit" type="submit" value="Submit">
    </form>
</body>
</html>
