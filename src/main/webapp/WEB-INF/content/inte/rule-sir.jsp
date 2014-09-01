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
		<h3>规则:直接输入单号</h3>
		<form role="form" action="<%=basePath%>inte/perform.action?formKey=applyList&ruleKey=sir"  method="post">
			<div class="form-group">
				<label for="no">单号</label> <input
					type="text" class="form-control" name="no" id="no"
					placeholder="单号" required autofocus >
			</div>
			<button type="submit" class="btn btn-default btn-lg btn-primary"  data-toggle="modal" data-target="#myModal">执行</button>
		</form>
	</div>
</body>
</html>
