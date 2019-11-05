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
	<form action="/studentInfo/add" method="post" id="infoForm">
		<input type="hidden" name="id" value="${studentInfo.id}" /> <input
			type="hidden" name="status_"
			value="${not empty studentInfo.status ? studentInfo.status : 1}" />
		<table>
			<tr>
				<td>学生编号：</td>
				<td><input type="text" value="${studentInfo.studentNum}"
					name="student_num" /></td>
			</tr>
			<tr>
				<td>班级编号：</td>
				<td><input type="text" value="${studentInfo.gradeId}"
					name="grade_id" /></td>
			</tr>
			<tr>
				<td>用户编号：</td>
				<td><input type="text" value="${studentInfo.userId}"
					name="user_id" /></td>
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
			var url = "/studentInfo/add";
			if ("${studentInfo.id}"!= "") {
				url = "/studentInfo/update";
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
							window.location.href="/studentInfo/page";
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