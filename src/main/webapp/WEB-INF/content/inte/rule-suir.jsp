<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>规则</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@include file="/bootstrap-header.jsp"%>
<link rel="stylesheet" href="<%=basePath%>css/grid.css">
</head>
<body>
	<div class="container">
		<h3>规则输入后缀</h3>
		<form role="form" action="<%=basePath%>inte/perform.action?formKey=applyList&ruleKey=suir"  method="post">
			<div class="form-group">
				<label for="no">尾数</label> <input
					type="text" class="form-control" name="no" id="no"
					placeholder="尾数" required autofocus >
			</div>
			<button type="submit" class="btn btn-default btn-lg btn-primary">执行</button>
		</form>
	</div>
</body>
</html>
