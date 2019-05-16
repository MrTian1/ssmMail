<%--
  Created by IntelliJ IDEA.
  User: tian
  Date: 2019/5/16
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=request.getContextPath() +"/"%>"/>
    <title>注册页面</title>
</head>

<body>
<form action="user/register" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    邮箱：<input type="text" name="mail"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>