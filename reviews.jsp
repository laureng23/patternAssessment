<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reviews</title>
</head>
<style>
table {
    font-family: arialf;
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
<body>
<h1>Book review</h1>
<table id="review">
    <thead>
        <tr>
            <th>Review</th>
            <th>Rating</th>
            <th>User</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td>${review.review}</td>
                <td>${review.rating}</td>
                <td>${review.username}</td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</body>

</html>