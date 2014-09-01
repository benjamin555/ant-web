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
		<h3>规则删除采办申请</h3>
		<form role="form" id="form1"
			action="<%=basePath%>inte/perform.action?formKey=caogaoList&ruleKey=ldar"
			method="post">
			<div class="form-group">
				<label for="loop">是否循环执行</label> <select
					class="form-control input-lg" name="loop" required autofocus>
					<option value="false">否</option>
					<option value="true">是</option>
				</select> <label for="loop">间隔（秒）</label> <input type="text"
					class="form-control" name="interval" id="interval"
					placeholder="间隔（秒）"   >
			</div>
			<div class="btn-group">
			  <button type="button" id="start" class="btn btn-default btn-lg ">启动</button>
			  <button type="button" id="stop" class="btn btn-default btn-lg " disabled="true">关闭</button>
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
	$("#form1").bind("submit", function() {
		$.ajax({
			   type: "POST",
			   url: this.action,
			   data: $(this).serialize(),
			   success: function(msg){
			   
			   }
			}); 
		
		return false;	
	});
	
	$("#start,#stop").click(function(){
		$(".btn-group>button").attr("disabled",false);
		$(this).attr("disabled",true);
		$("#form1").trigger("submit");
	});
	
	list(); 
	
	function list(){
		 
		$.ajax({
			   type: "POST",
			   url: "<%=basePath%>inte/monitor.action?formKey=caogaoList&ruleKey=ldar",
			   data: $(this).serialize(),
			   dataType:"JSON",
			   success: function(msg){
				   $("#monitor").html("");
				   var html = "";
				  for(var i in msg){
					  html+=msg[i].no+"</br>";
				  }
			   	 $("#monitor").html(html);
			     window.setTimeout(list, 5000);
			   },
			   error:function(msg){
				   alert("error");
			   }
			}); 
	}
	
});
</script>
