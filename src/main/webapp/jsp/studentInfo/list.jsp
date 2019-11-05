<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页分页</title>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td><input type="checkbox" value="all"></td>
			<td>学生编号</td>
			<td>班级编号</td>
			<td>用户编号</td>
			<td>班级状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageData}" var="list" varStatus="i">
			<tr>
			<td><input type="checkbox" value="${list.id }"></td>
			<td>${list.studentNum }</td>
			<td>${list.gradeId }</td>
			<td>${list.userId}</td>
			<td>${list.status }</td>
			<td>
				<a href="/studentInfo/update?id=${list.id }">修改</a>
				<a href="javascrpit:void(0)" onclick="del('${list.id}')">删除</a>
			</td>
			</tr>
		</c:forEach>
		
	</table>
	<table>
		<tr><td>当前${page.currentPage}/${page.totalPage}页 共${page.totalCount } 条</td>
		<td><a href="/studentInfo/page?pageNum=1">首页</a></td>
		<c:if test="${ page.currentPage>1}">
		<td><a href="/studentInfo/page?pageNum=${page.currentPage-1 }">上一页</a></td>
		</c:if>
		<c:if test="${ page.currentPage<page.totalPage}">
		<td><a href="/studentInfo/page?pageNum=${page.currentPage+1 }">下一页</a></td>
		</c:if>
		<td><a href="/studentInfo/page?pageNum=${page.totalPage }">尾页</a></td>
		</tr>
	</table>
	<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function del(elemt){
			jQuery.ajax({
				url : "/studentInfo/delete?id="+elemt,
				type : "POST",
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