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

<title>Struts Login App</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Struts,Login,Java">
<meta http-equiv="description" content="Struts Login App">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-table.css">
<link rel="stylesheet" href="css/css/bootstrap-theme.min.css">
</head>

<body>
<div class="container">
    <h1>Table from html</h1>
    <p>Transform table from an existing, unformatted html table.</p>
    
    <table data-toggle="table" data-height="460" data-row-style="rowStyle">
        <thead>
        <tr>
            <th><i class="glyphicon glyphicon-star"></i>ID</th>
            <th><i class="glyphicon glyphicon-heart"></i>User Name</th>
            <th><i class="glyphicon glyphicon-heart"></i>Password</th>
            <th data-align="center"><i class="glyphicon glyphicon-cog"></i>Action</th>
        </tr>
        </thead>
        
        <tbody>
        <tr>
            <td>1</td>
            <td>Liu Qiang</td>
            <td>123456</td>
            <td><a href="https://github.com/wenzhixin/bootstrap-table">Update</a></td>
        </tr>
        <tr id="tr-id-2" class="tr-class-2">
            <td>2</td>
            <td>Zhang Ji</td>
            <td>123456</td>
            <td><a href="https://github.com/wenzhixin/bootstrap-table">Update</a></td>
        </tr>
        <tr id="tr-id-3" class="tr-class-3">
            <td>3</td>
            <td>Qi Dongjie</td>
            <td>123456</td>
            <td><a href="https://github.com/wenzhixin/bootstrap-table">Update</a></td>
        </tr>
    	
        </tbody>
    </table>
</div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
<script>
    function rowStyle(row, index) {
        var classes = ['active', 'success', 'info', 'warning', 'danger'];
        if (index % 2 === 0) {
            return {
                classes: 'active'
            };
        }
        return {};
    }
</script>
</html>
