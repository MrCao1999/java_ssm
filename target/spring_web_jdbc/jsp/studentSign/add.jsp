<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增</title>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
</head>
<body>
	<form action="/studentSign/add" method="post" id="infoForm">
		<input type="hidden" name="id" value="${studentSign.id}" /> <input
			type="hidden" name="status_"
			value="${not empty studentSign.status_ ? studentSign.status_ : 1}" />
		<table>
			<tr>
				<td>用户id：</td>
				<td><input type="text" value="${studentSign.user_id}"
					name="user_id" /></td>
			</tr>
			<tr>
				<td>签到时间：</td>
				<td><input type="text" value="${studentSign.sign_time}"
					name="sign_time" /></td>
			</tr>
			<tr>
				<td>签到地址：</td>
				<td><input type="text" value="${studentSign.sign_address}"
					name="sign_address" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="submitForm()">提交</button>
				</td>

			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function submitForm() {
			var url = "/studentSign/add";
			if ("${studentSign.id}"!= "") {
				url = "/studentSign/update";
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
							window.location.href="/studentSign/page";
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