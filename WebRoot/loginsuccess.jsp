<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Struts Login Success</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Struts,Login,Java">
<meta http-equiv="description" content="Struts Login App">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="panel panel-success">
		<div class="panel-heading">Login Success.</div>
		<div class="panel-body">
		<ul>
			<li>Using Struts2 mapping the actions and views.</li>
			<li>After action check go to this page.</li>
		</ul>
		</div>
	</div>
</body>
</html>
