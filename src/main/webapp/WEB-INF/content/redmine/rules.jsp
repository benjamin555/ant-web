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
		<h3>规则</h3>
		<s:iterator var="f" status="status" value="redmineSite.forms">
		
			<p>
				表单:
				<s:property value="#f.key" />
			</p>
			<ul class="nav nav-pills nav-stacked">
				<s:iterator var="rule" value="#f.rules">
					<li class="active"><a href="<%=basePath%>/redmine/rule-<s:property value="#rule.key" />.action"><s:property value="#rule.name" /></a></li>
				</s:iterator>
			</ul>
		</s:iterator>
</body>
</html>
