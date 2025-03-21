<%@ page import="Model.CustomerBean" %>
<%
    String customerName = (String) request.getAttribute("customerName");
    Integer totalCharge = (Integer) request.getAttribute("totalCharge");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
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
            height: 100vh;
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
            max-width: 500px;
            width: 90%;
            padding: 30px;
            background: linear-gradient(135deg, #f9f9f9, #ffffff);
            border-radius: 10px;
            box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin-top: 40px;
        }

        h2 {
            font-size: 2rem;
            color: #333;
            margin-bottom: 25px;
        }

        .message {
            font-size: 1.1rem;
            color: #555;
            margin: 15px 0;
            line-height: 1.5;
        }

        .thank-you {
            font-weight: bold;
            color: #36d1dc;
            margin-top: 25px;
            font-size: 1.2rem;
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
    <h2>Order Confirmation</h2>
    <p class="message">Hello <strong><%= customerName %></strong>,</p>
    <p class="message">You have been charged <strong>Rs.<%= totalCharge %></strong>.</p>
    <p class="thank-you">Thank you for your purchase!</p>
</div>

</body>
</html>
