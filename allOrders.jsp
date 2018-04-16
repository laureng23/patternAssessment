<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
    font-family: arial;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 10px solid #dddddd;
    text-align: left;
    padding: 10px;


</style>
<body>
<div>
<table id="orders">
    <thead>
        <tr>
            <th >Order Id</th>
            <th >Info</th>
            <th >Total Payable</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>
                	<div>
                		<table id="entry">
						    <thead>
						        <tr>
						            <th>Book</th>
						            <th>Quantity</th>
						            <th>Price</th>
						        </tr>
						    </thead>
						    <tbody>
						        <c:forEach var="info" items="${order.info}">
						            <tr>
						                <td>${info.book.title}</td>
						                <td>${info.quantity}</td>
						                <td>${info.price}</td>
						            </tr>       
						        </c:forEach>
						    </tbody>
						</table>
                	</div>
                </td>
                <td>${order.totalPrice}</td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>