<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.CustomerBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #36d1dc, #5b86e5);
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .navbar {
            width: 100%;
            background: linear-gradient(90deg, #5b86e5, #36d1dc);
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
        }

        .navbar h1 {
            font-size: 1.6rem;
            color: #ffffff;
            font-weight: bold;
        }

        .navbar .nav-links {
            list-style: none;
            display: flex;
            gap: 20px;
        }

        .navbar .nav-links a {
            text-decoration: none;
            color: #ffffff;
            font-size: 1rem;
            padding: 8px 12px;
            border-radius: 5px;
            transition: background 0.3s ease;
        }

        .navbar .nav-links a:hover {
            background-color: rgba(255, 255, 255, 0.2);
        }

        .container {
            max-width: 600px;
            width: 90%;
            padding: 30px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin-top: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .welcome-text {
            font-size: 1.6rem;
            font-weight: 600;
            margin-bottom: 20px;
            color: #5b86e5;
        }

        .welcome-message {
            font-size: 1.1rem;
            color: #555;
            margin-bottom: 25px;
            line-height: 1.6;
        }

        .btn {
            display: inline-block;
            margin: 10px 5px;
            padding: 10px 20px;
            font-size: 1rem;
            color: #ffffff;
            text-decoration: none;
            background-color: #007bff;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h1>Electronic Store</h1>
    <ul class="nav-links">
        <li><a href="home">Home</a></li>
        <li><a href="viewp2">View Product</a></li>
        <li><a href="orders">My Orders</a></li>
        <li><a href="clogout">Logout</a></li>
    </ul>
</div>

<div class="container">
    <%
        CustomerBean cbean = (CustomerBean) session.getAttribute("name");
        if (cbean != null) {
    %>
        <p class="welcome-text">Hello, <%= cbean.getFname() %>!</p>
        <p class="welcome-message">Welcome back to Your Shop! We're thrilled to have you here. Browse our products, manage your orders, or explore the latest collections just for you. Have a great shopping experience!</p>
    <% } else { %>
        <p class="welcome-text">Welcome, Guest!</p>
        <p class="welcome-message">Hello! Explore our store, check out our latest collections, or log in to access personalized features. We're excited to have you here!</p>
    <% } %>
    
    <a href="viewp2" class="btn">View Products</a>
    <a href="clogout" class="btn">Logout</a>
</div>

</body>
</html>
