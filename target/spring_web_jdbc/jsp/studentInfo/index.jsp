<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="/layui/css/layui.css" media="all">
  <style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">学生管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="/grade/page">班级信息</a></li>
      <li class="layui-nav-item"><a href="/studentInfo/page">学生信息</a></li>
      <li class="layui-nav-item"><a href="/studentSign/page">学生登记信息</a></li>
       <li class="layui-nav-item"><a href="/userInfo/page">用户信息</a></li>
<!--       <li class="layui-nav-item"> -->
<!--         <a href="javascript:;">其它系统</a> -->
<!--         <dl class="layui-nav-child"> -->
<!--           <dd><a href="">邮件管理</a></dd> -->
<!--           <dd><a href="">消息管理</a></dd> -->
<!--           <dd><a href="">授权管理</a></dd> -->
<!--         </dl> -->
<!--       </li> -->
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
       ${sessionScope.userInfo.userName}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="/userInfo/login">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
<!--       <ul class="layui-nav layui-nav-tree"  lay-filter="test"> -->
<!--         <li class="layui-nav-item layui-nav-itemed"> -->
<!--           <a class="" href="javascript:;">所有商品</a> -->
<!--           <dl class="layui-nav-child"> -->
<!--             <dd><a href="javascript:;">列表一</a></dd> -->
<!--             <dd><a href="javascript:;">列表二</a></dd> -->
<!--             <dd><a href="javascript:;">列表三</a></dd> -->
<!--             <dd><a href="">超链接</a></dd> -->
<!--           </dl> -->
<!--         </li> -->
<!--         <li class="layui-nav-item"> -->
<!--           <a href="javascript:;">解决方案</a> -->
<!--           <dl class="layui-nav-child"> -->
<!--             <dd><a href="javascript:;">列表一</a></dd> -->
<!--             <dd><a href="javascript:;">列表二</a></dd> -->
<!--             <dd><a href="">超链接</a></dd> -->
<!--           </dl> -->
<!--         </li> -->
<!--         <li class="layui-nav-item"><a href="">云市场</a></li> -->
<!--         <li class="layui-nav-item"><a href="">发布商品</a></li> -->
<!--       </ul> -->
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
<!--     内容主体区域 -->
<p>
	<a href="/studentInfo/add">新增</a>
</p>
<table border="1">
		<tr>
			<td><input type="checkbox" value="all"></td>
			<td>学生编号</td>
			<td>班级编号</td>
			<td>用户编号</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageData}" var="list" varStatus="i">
			<tr>
			<td><input type="checkbox" value="${list.id }"></td>
			<td>${list.studentNum }</td>
			<td>${list.gradeId }</td>
			<td>${list.userId}</td>
			<td>
				<c:if test="${list.status ==1 }">
					普通学生
				</c:if>
			</td>
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
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src="../../layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</div>
</body>
</html>