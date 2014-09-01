<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>登录界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>css/signin.css">
<%@include file="/bootstrap-header.jsp"%>
</head>
<body>
	<div class="container">
		<form role="form" action="<%=basePath%>/location.action"
			method="post" >
			<label for="url">网址:</label>
			<select class="form-control input-lg"  name="site" required autofocus >
				<option value="redmine" >redmine</option>
				<option value="inte" >需求</option>
				<option value="douban" >豆瓣</option>
			</select>
			<br />	
			<input class="btn btn-lg btn-primary " value="提交"
				type="submit" data-toggle="modal" data-target="#myModal" />
		</form>
	</div>
</body>
</html>
