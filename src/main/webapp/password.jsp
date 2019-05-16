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
	<a>修改密码</a>
	<form action="user/getpass" method="post">
	<table>
		<tr>
			<td>输入账号</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="找回密码">
			</th>
		</tr>
	</table>
	</form>
</body>
</html>