<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.AdminBean" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Welcome</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .navbar {
            width: 100%;
            background-color: #333;
            padding: 15px;
            display: flex;
            justify-content: center;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
        }

        .navbar a {
            color: #ffffff;
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }

        .navbar a:hover {
            color: #00f2fe;
        }

        .welcome-container {
            max-width: 400px;
            width: 90%;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin-top: 50px;
        }

        h1 {
            font-size: 1.8rem;
            color: #333;
            margin-bottom: 10px;
        }

        .welcome-text {
            font-size: 1.2rem;
            color: #2c3e50;
            font-weight: 600;
            margin-bottom: 20px;
        }

        .message {
            font-size: 1rem;
            color: #555;
            margin: 15px 0;
            line-height: 1.5;
        }
    </style>
</head>
<body>

<%
    AdminBean abean = (AdminBean) session.getAttribute("aname");
    String msg = (String) request.getAttribute("msg");
%>


<div class="navbar">
    <a href="addProduct.jsp">Add Product</a>
    <a href="viewp">View Product</a>
    <a href="clogout">Logout</a>
</div>


<div class="welcome-container">
    <h1>Welcome, Admin</h1>
    <p class="welcome-text">Hello, <%= abean != null ? abean.getFname() : "Admin" %>!</p>
    <p class="message"><%= msg != null ? msg : "No new messages." %></p>
</div>

</body>
</html>
