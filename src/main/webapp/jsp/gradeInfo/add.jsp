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
	<form action="/grade/add" method="post" id="infoForm">
		<input type="hidden" name="id" value="${gradeInfo.id}" /> <input
			type="hidden" name="status"
			value="${not empty gradeInfo.status ? gradeInfo.status : 1}" />
		<table>
			<tr>
				<td>班级名称：</td>
				<td><input type="text" value="${gradeInfo.gradeName}"
					name="gradeName" /></td>
			</tr>
			<tr>
				<td>班级编号：</td>
				<td><input type="text" value="${gradeInfo.gradeId}"
					name="gradeId" /></td>
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
			var url = "/grade/add";
			if ("${gradeInfo.id}"!= "") {
				url = "/grade/update";
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
							window.location.href="/grade/page";
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