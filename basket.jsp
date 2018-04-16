<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Basket</title>
<style>
table {
    font-family: arial;
    border-collapse: collapse;
    width: 100%;
}
td, th {
    border: 10px solid ;
    text-align: left;
    padding: 10px;
}
}
</style>
</head>
<body>
<h1>Basket</h1>
<div>
<table id="basket">
    <thead>
        <tr>
            <th>Book</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="info" items="${basket.info}">
            <tr>
                <td>${info.book.title}</td>
                <td>${info.quantity}</td>
                <td>${info.price}</td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
<h2>Total Payable: ${basket.totalPrice}</h2>
</div>
<div>
 <form action="/books" id="goback">
    <input type="submit" value="Continue Shopping" />
  </form>
</div>
<br>
  <div>
  <form action="/order/confirmOrder" method="POST" id="checkout">
    <input type="submit" value="Checkout" />
  </form>
</div>
    <div>
    	<br>
</body>
</html>