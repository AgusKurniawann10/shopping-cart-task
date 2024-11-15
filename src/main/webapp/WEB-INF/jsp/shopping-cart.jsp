<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .product-list {
            width: 800px;
            margin: 20px auto;
            border: 1px solid #000;
            padding: 10px;
        }
        .product-list h2 {
            margin: 0;
            padding: 5px;
            border-bottom: 1px solid #000;
            font-size: 16px;
        }
        .product-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
            padding: 20px;
        }
        .product-card {
            border: 2px solid #ccc;
            padding: 15px;
            background-color: #FAEBD7;
            box-shadow: 3px 3px 5px rgba(0,0,0,0.1);
        }
        .form-group {
            margin-bottom: 10px;
            display: flex;
            align-items: center;
        }
        .form-group label {
            width: 60px;
            margin-right: 5px;
        }
        .form-group input[type="text"],
        .form-group select {
            width: 200px;
            padding: 3px;
            border: 1px solid #999;
            background-color: white;
        }
        .quantity-group {
            text-align: right;
            margin: 15px 0;
        }
        .quantity-group label {
            margin-right: 5px;
        }
        .quantity-group input {
            width: 50px;
            padding: 2px;
            border: 1px solid #999;
        }
        .add-to-cart {
            text-align: right;
        }
        .add-to-cart button {
            padding: 3px 15px;
            background-color: #f0f0f0;
            border: 1px solid #999;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="product-list">
        <h2>Shopping Cart</h2>
        <div class="product-container">
            <c:forEach items="${data_product}" var="p">
                <div class="product-card">
                    <form action="${pageContext.request.contextPath}/backoffice/cart/add" method="post">
                        <input type="hidden" name="productNo" value="${p.no}">

                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" name="name" value="${p.name}" readonly>
                        </div>

                        <div class="form-group">
                            <label>Type</label>
                            <input type="text" name="Type" value="${p.type}" readonly>
                        </div>

                        <div class="form-group">
                            <label>Price Rp</label>
                            <input type="text" name="price" value="${p.price}" readonly>
                        </div>

                        <div class="quantity-group">
                            <label>Quantity</label>
                            <input type="number" name="quantity" value="1" min="1">
                        </div>

                        <div class="add-to-cart">
                            <button type="submit">Add To Cart</button>
                        </div>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>