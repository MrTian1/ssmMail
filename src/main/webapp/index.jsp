<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <base href="<%=request.getContextPath() +"/"%>"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<font color="#7fff00">${message}</font>
<form action="user/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <a href="register.jsp">注册</a>|
    <a href="password.jsp">忘记密码</a>
    <input type="submit" value="登陆">
</form>
</body>
</html>