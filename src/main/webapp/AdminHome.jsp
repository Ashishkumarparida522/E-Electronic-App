<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.AdminBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
     
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }
     
        .dashboard-container {
            background-color: #ffffff;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 350px;
        }
        .dashboard-container h2 {
            font-size: 1.8rem;
            margin-bottom: 1.2rem;
            color: #333;
        }
        .username {
            color: #007bff;
            font-weight: bold;
        }
      
        .nav-links {
            display: flex;
            flex-direction: column;
            gap: 1rem;
            margin-top: 2rem;
        }
        .nav-links a {
            display: inline-block;
            padding: 0.8rem 1.5rem;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            font-weight: bold;
        }
        .nav-links a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
    
    AdminBean admin = (AdminBean) session.getAttribute("aname");
    String adminName = (admin != null) ? admin.getFname() : "Admin";
%>

<div class="dashboard-container">
    <h2>Welcome, <span class="username"><%= adminName %></span></h2>
    <p>Manage your store below</p>

   
    <div class="nav-links">
        <a href="Addproduct.html">Add Product</a>
        <a href="viewp">View Products</a>
        <a href="alogout">Logout</a>
    </div>
</div>

</body>
</html>
