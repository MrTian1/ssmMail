<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <base href="${pageContext.request.contextPath }/"/> -->
<base href="<%=request.getContextPath() +"/"%>"/>
<script type="text/javascript" src="js/jquery.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title> 

<script type="text/javascript">
	
	function getMail(){
		
		var mail = $("#mail").val();
		$.post("user/getMail?mail="+mail,function(data){
			alert("邮件已发送");
		},"JSON")
	}
	
</script>
</head>
<body>
${msg}
<form action="user/register" method="post" >
<table >
	<tr>
		<td>用户名:</td>
		<td><input type="text" id="username" name="username"></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="text" id="password" name="password"></td>
	</tr>
	<tr>
		<td>邮箱:</td>
		<td>
			<input type="text" id="mail" name="mail" value="">
			<input type="button" onclick="getMail()" value="获取验证码">
		</td>
	</tr>
	<tr>
		<td>验证码:</td>
		<td><input type="text" name="code"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="注册">
		</td>
	</tr>
</table>
</form>
	
</body>
</html>