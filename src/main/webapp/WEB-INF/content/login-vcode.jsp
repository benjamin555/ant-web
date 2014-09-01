<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<form class="form-signin" action="<%=basePath%><s:property value='formUrl'/>"
			method="post">
			<label for="userName">帐号：</label><input class="form-control"
				name="userName" placeholder="帐号" required autofocus /><label
				for="password">密码:</label> <input class="form-control"
				name="password" type="password" placeholder=" 密码" required /><br />
			<label for="vcode">验证码:</label><img class="form-control"
				src='<s:property value="imgSrc"/>' alt="验证码" /> <br /> <input
				class="form-control" name="vcode" type="text" placeholder=" 验证码"
				required /><br /> <input class="btn btn-lg btn-primary btn-block"
				value="提交" type="submit" data-toggle="modal" data-target="#myModal" />
		</form>
	</div>
</body>
</html>
