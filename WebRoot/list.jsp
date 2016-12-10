<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
    <h1>User Information List</h1>
    <p>Transform table from DB data.</p>
    <div id="toolbar">
            <div class="form-inline" role="form">
                <button id="ok"  onclick="javascript:window.location.href='addInfor.jsp'" class="btn btn-danger">Add new User</button>
            </div>
    </div>
    <br/>
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
        <s:iterator value="list" id="u">
        	<tr>
	            <td>${u.id }</td>
	            <td>${u.username }</td>
	            <td>${u.userpwd }</td>
	            <td><a href="edit?id=${u.id }">Update</a> || <a href="delete?id=${u.id }">Delete</a></td>
	        </tr>
        </s:iterator>
        
        
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
