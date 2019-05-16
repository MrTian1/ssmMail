<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath() +"/"%>"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改密码</h1>
	<form action="user/update" method="post">
	<input type="hidden" name="id" value="${user.id}">
	<input type="hidden" name="username" value="${user.username}">
	<input type="hidden" name="mail" value="${user.mail}">
	<input type="hidden" name="code" value="${user.code}">
		新的密码:<input type="text" name="password"><br>
		<input type="submit" value="修改">
	</form>
</body>
</html>