<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="Model.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean abean=(AdminBean)session.getAttribute("name");

out.println("welcome"+abean.getFname());

String msg1=(String)request.getAttribute("msg");
out.println(msg1);
%>

</body>
</html>