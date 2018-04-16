<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
</head>
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


</style>
<body>
<table id="users">
    <thead>
        <tr>
            <th >User name</th>
            <th >Payment </th>
            <th >Address</th>
            <th>Orders</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.paymentMethod}</td>
                <td>${user.shippingAddress}</td>
                 <td><a href="/order/user/${user.username}">Show all orders</a></td>
                </td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>