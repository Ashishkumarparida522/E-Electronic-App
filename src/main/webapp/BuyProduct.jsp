<%@ page import="Model.ProductBean" %>
<%
    ProductBean product = (ProductBean) request.getAttribute("pcode");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buy Product</title>
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
            background: linear-gradient(to right, #6a11cb, #2575fc);
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        /* Container Styling */
        .container {
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

        /* Product Details Styling */
        .product-detail {
            font-size: 1rem;
            margin: 10px 0;
            color: #555;
        }

        /* Label and Input Styling */
        label {
            display: block;
            font-weight: 600;
            margin: 15px 0 5px;
            color: #333;
        }

        input[type="number"] {
            width: 100%;
            padding: 8px;
            font-size: 1rem;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* Button Styling */
        button {
            width: 100%;
            padding: 10px;
            font-size: 1rem;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Back Button Styling */
        .back-link {
            display: block;
            margin-top: 15px;
            font-size: 0.9rem;
            color: #007bff;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Product Details</h2>
    <p class="product-detail"><strong>Name:</strong> <%= product.getpName() %></p>
    <p class="product-detail"><strong>Company:</strong> <%= product.getpCompnay() %></p>
    <p class="product-detail"><strong>Price:</strong> Rs<%= product.getpPrice() %></p>
    <p class="product-detail"><strong>Available Quantity:</strong> <%= product.getpQuantity() %></p>

    <form action="updateProduct" method="post">
        <input type="hidden" name="pCode" value="<%= product.getpCode() %>">
        
        <label for="requiredQuantity">Enter Quantity:</label>
        <input type="number" name="requiredQuantity" id="requiredQuantity" min="1" required>

        <button type="submit">Confirm Purchase</button>
    </form>
    
  
</div>

</body>
</html>
