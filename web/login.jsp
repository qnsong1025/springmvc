<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2016/12/16
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="/login" method="post">
        <input type="text" name="username" />
        <input type="password" name="password"/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
