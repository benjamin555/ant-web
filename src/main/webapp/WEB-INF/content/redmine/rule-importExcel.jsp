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
<%--<script src="<%=basePath%>js/jquery-html5Validate.js"></script>--%>
</head>
<body>
	<div class="container">
		<div class="row">
		<h3>批量新建</h3>
		<form  role="form" action="<%=basePath%>redmine/perform.action?formKey=<s:property value="#parameters.formKey" />&ruleKey=importExcel" method="post"
				enctype="multipart/form-data">
			<div class="form-group">
				<span>请选择excel</span> <input
					id="fileupload" type="file" name="dataExcel"  required>
			</div>
			<div class="btn-group">
			  <button type="submit" id="start" class="btn btn-default btn-lg ">启动</button>
			</div>
		</form>
		</div>
		<div class="row" id="monitor">
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
$(function(){
	
	
});
</script>
