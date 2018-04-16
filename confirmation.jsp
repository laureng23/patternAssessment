<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
</head>
<style>
table {
    font-family: arial;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 10px solid;
    text-align: left;
    padding: 10px;
}

</style>
<body>
<h1>Confirmation</h1>
<div>
<h3>Order Code: ${order.id}</h3>
<table id="basket">
    <thead>
        <tr>
            <th>Book</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="infor" items="${order.info}">
            <tr>
                <td>${info.book.title}</td>
                <td>${info.quantity}</td>
                <td>${info.price}</td>
            </tr>       
        </c:forEach>
    </tbody>
    <h3>Total Price: ${order.totalPrice}</h3>
</table>

</div>
</body>
</html>