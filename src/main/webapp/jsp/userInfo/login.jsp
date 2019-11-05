<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="/css/login.css"/>
	</head>
	<body>
		<div class="bg">
			<div class="login">
				<form action="login" method="post">
					<p><span>用户名：</span><input type="text" name="user_name" placeholder="请输入账号"/><br /></p>
					<p><span>密码：</span><input type="password" name="password_" placeholder="请输入密码"/><br /></p>
					<input type="submit" value="登录"/>
					<p>还没有账号？立即<a href="register.jsp">注册</a></p>
				</form>
			</div>
		</div>
	</body>
</html>
