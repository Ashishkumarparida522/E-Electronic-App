<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.AdminBean" %>
<%@ page import="Model.ProductBean" %>
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
            background: #f4f4f9;
        }

        .navbar {
            background-color: #333;
            overflow: hidden;
            color: white;
            padding: 14px 20px;
            text-align: center;
        }

        .navbar a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
            display: inline-block;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .welcome-msg {
            text-align: center;
            margin-top: 20px;
            font-size: 20px;
            color: #333;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <a href="#">Home</a>
        <a href="#">Products</a>
        <a href="alogout">Logout</a>
    </div>

    <div class="welcome-msg">
        <%
            AdminBean abean = (AdminBean) session.getAttribute("aname");
            if (abean != null) {
                out.println("Welcome " + abean.getFname() + ", here are all the product details:");
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
                ArrayList<ProductBean> li = (ArrayList<ProductBean>)request.getAttribute("product");
                if (li != null) {
                    for (ProductBean pbean : li) {
            %>
                        <tr>
                            <td><%= pbean.getpCode() %></td>
                            <td><%= pbean.getpName() %></td>
                            <td><%= pbean.getpCompnay()  %></td>
                            <td><%= pbean.getpPrice() %></td>
                            <td><%= pbean.getpQuantity() %>&nbsp;&nbsp;
    <a href="edit?pCode=<%= pbean.getpCode() %>">Edit</a>&nbsp;&nbsp;
    <a href="delete?pCode=<%= pbean.getpCode() %>">Delete</a>
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
