<%@page import="oracle.security.o3logon.a"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="Model.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	AdminBean abean=(AdminBean)session.getAttribute("aname");
	out.println("welocme"+abean.getFname());
	String msg=(String )request.getAttribute("msg");
	out.println(msg);
	
	

%>
<a href="">Add Product</a>
<a href="viewp">View Product</a>
<a href="logout">logout</a>
</body>
</html>