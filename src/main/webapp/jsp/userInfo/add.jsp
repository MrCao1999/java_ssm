<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增</title>
</head>
<body>
<form action="/userInfo/add" method="post" id="infoForm">
		<input type="hidden" name="id" value="${userInfo.id}" /> <input
			type="hidden" name="status_"
			value="${not empty userInfo.status ? userInfo.status : 1}" />
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" value="${userInfo.userName}"
					name="user_name" /></td>
			</tr>
			<tr>
				<td>用户昵称：</td>
				<td><input type="text" value="${userInfo.realName}"
					name="real_name" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" value="${userInfo.password}"
					name="password_" /></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" value="${userInfo.email}"
					name="email" /></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" value="${userInfo.phone}"
					name="phone" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="button" onclick="submitForm()">提交</button>
				</td>

			</tr>
		</table>
	</form>
	<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function submitForm() {
			var url = "/userInfo/add";
			if ("${userInfo.id}"!= "") {
				url = "/userInfo/update";
			}
			jQuery.ajax({
				url : url,
				type : "POST",
				data : jQuery('#infoForm').serialize(),
				success : function(data) {
					var json = eval("(" + data + ")");
					if (json.status == 200) {
						var isPass = confirm(json.meassage);
						if(isPass){
							window.location.href="/userInfo/page";
						}
						
					} else {
						alert(json.meassage);
					}
				}
			});
		}
	</script>
</body>
</html>