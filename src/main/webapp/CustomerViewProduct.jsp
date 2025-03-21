<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.ProductBean" %>
<%@ page import="Controller.ViewProductToCustomer" %>
<%@ page import="Model.CustomerBean" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #e0f7fa, #e1bee7);
            color: #333;
        }

        .navbar {
            background: linear-gradient(90deg, #5b86e5, #36d1dc);
            color: white;
            padding: 14px 20px;
            text-align: center;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.15);
        }

        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            display: inline-block;
            font-weight: bold;
            transition: background 0.3s;
        }

        .navbar a:hover {
            background-color: #ffffff33;
            color: #333;
        }

        .welcome-msg {
            text-align: center;
            margin-top: 20px;
            font-size: 1.5rem;
            color: #333;
        }

        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            background-color: #ffffff;
            border-radius: 8px;
            overflow: hidden;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th {
            padding: 14px;
            background-color: #5b86e5;
            color: white;
            font-weight: bold;
            text-align: left;
        }

        td {
            padding: 12px;
            text-align: left;
            color: #333;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #e0f7fa;
        }

        .buy-link {
            color: #5b86e5;
            text-decoration: none;
            font-weight: bold;
            padding: 4px 8px;
            background-color: #e1f5fe;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .buy-link:hover {
            background-color: #b3e5fc;
            color: #333;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="landingPage.html">Home</a>
        <a href="#">Products</a>
        <a href="clogout">Logout</a>
    </div>

    <div class="welcome-msg">
        <%
            CustomerBean cbean = (CustomerBean) session.getAttribute("name");
            if (cbean != null && cbean.getFname() != null) {
                out.println("Welcome " + cbean.getFname() + ", here are all the product details:");
            } else {
                out.println("Session expired or not available. Please log in.");
            }
        %>
    </div>

    <table>
        <thead>
            <tr>
                <th>Product Code</th>
                <th>Product Name</th>
                <th>Product Company</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<ProductBean> li = (ArrayList<ProductBean>) request.getAttribute("plist");
                if (li != null) {
                    for (ProductBean pbean : li) {
            %>
                        <tr>
                            <td><%= pbean.getpCode() %></td>
                            <td><%= pbean.getpName() %></td>
                            <td><%= pbean.getpCompnay() %></td>
                            <td>Rs.<%= pbean.getpPrice() %></td>
                            <td><%= pbean.getpQuantity() %>&nbsp;&nbsp;
                                <a href="buy?pCode=<%= pbean.getpCode() %>" class="buy-link">Buy</a>
                            </td>
                        </tr>
            <%
                    }
                } else {
                    out.println("<tr><td colspan='5' style='text-align:center;'>No products available.</td></tr>");
                }
            %>
        </tbody>
    </table>

</body>
</html>
