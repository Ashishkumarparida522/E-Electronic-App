<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.AdminBean" %>
<%@ page import="Model.ProductBean" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Product Details</title>
    <style>
        /* Reset some default browser styling */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body Styling */
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2980b9, #6dd5fa);
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        /* Container Styling */
        .form-container {
            max-width: 400px;
            width: 90%;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        /* Title Styling */
        h2 {
            font-size: 1.8rem;
            color: #333;
            margin-bottom: 20px;
        }

        /* Label and Input Styling */
        label {
            display: block;
            font-weight: 600;
            margin-top: 15px;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 1rem;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* Hidden Input Styling */
        input[type="hidden"] {
            display: none;
        }

        /* Button Styling */
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            font-size: 1rem;
            color: #ffffff;
            background-color: #2980b9;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 15px;
        }

        input[type="submit"]:hover {
            background-color: #1a5276;
        }
    </style>
</head>
<body>

<%
    ProductBean pbean = (ProductBean) request.getAttribute("pbean");
%>

<div class="form-container">
    <h2>Update Product Details</h2>
    <form action="update" method="post">
        <label for="pprice">Product Price</label>
        <input type="text" id="pprice" name="pprice" value="<%= pbean.getpPrice() %>" placeholder="Enter product price">

        <label for="pqty">Product Quantity</label>
        <input type="text" id="pqty" name="pqty" value="<%= pbean.getpQuantity() %>" placeholder="Enter product quantity">
        
        <input type="hidden" name="pcode" value="<%= pbean.getpCode() %>">

        <input type="submit" value="Update Details">
    </form>
</div>

</body>
</html>
