<%@ page import="com.wide.latihan.entity.Order" %>
<%@ page import="com.wide.latihan.entity.OrderItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .cart-container {
            width: 800px;
            margin: 20px auto;
            border: 1px solid #000;
            padding: 10px;
        }
        .cart-container h2 {
            margin: 0;
            padding: 5px;
            border-bottom: 1px solid #000;
            font-size: 16px;
            font-weight: normal;
        }
        .customer-info {
            margin: 15px 10px;
            line-height: 1.8;
        }
        .customer-info div {
            display: flex;
        }
        .customer-label {
            width: 80px;
        }
        .cart-table {
            width: calc(100% - 20px);
            margin: 10px;
            border-collapse: collapse;
        }
        .cart-table th {
            background-color: #e0e0e0;
            padding: 5px;
            text-align: left;
            border: 1px solid #999;
        }
        .cart-table td {
            padding: 5px;
            border: 1px solid #999;
        }
        .checkbox-column {
            width: 30px;
            text-align: center;
        }
        .total-row {
            text-align: right;
            margin: 10px;
            padding-right: 10px;
            font-weight: normal;
        }
        .place-order {
            text-align: right;
            margin: 10px;
            padding-right: 10px;
        }
        .place-order button {
            padding: 2px 15px;
            background-color: #f0f0f0;
            border: 1px solid #999;
            cursor: pointer;
            font-family: Arial;
            font-size: 12px;
        }
        input[type="checkbox"] {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <h2>Order Cart</h2>
        
        <div class="customer-info">
            <div>
                <span class="customer-label">Customer</span>
                <span>: ${sessionScope.loginContext}</span>
            </div>

        </div>

        <form action="${pageContext.request.contextPath}/backoffice/cart/placeOrder" method="post">
            <table class="cart-table">
                <tr>
                <th class="checkbox-column"><input type="checkbox" onclick="toggleAll(this)" checked></th>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Total</th>
                </tr>
                <c:forEach items="${sessionScope.order.items}" var="item">
                    <tr>
                        <td class="checkbox-column">
                            <input type="checkbox" name="selectedItems" value="${item.product.no}" checked>
                        </td>
                        <td>${item.product.name}</td>
                        <td>${item.product.type}</td>
                        <td>${item.product.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.totalPrice}</td>
                    </tr>
                </c:forEach>
            </table>

            <div class="total-row">
                Total : ${sessionScope.order.total}
            </div>

            <div class="place-order">
                <button type="submit">Place Order</button>
            </div>
        </form>
    </div>

    <script>
        function toggleAll(source) {
            var checkboxes = document.getElementsByName('selectedItems');
            for(var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = source.checked;
            }
        }
    </script>
</body>
</html>