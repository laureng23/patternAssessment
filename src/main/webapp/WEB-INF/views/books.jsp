<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books in System</title>
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

tr:nth-child(even) {
    background-color: ;
}

#books {
    font-family: Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#books td, #customers th {
    border: 10px solid ;
    padding: 1-px;
}

#books th {
    padding-top: 120px;
    padding-bottom: 20;
    text-align: left;
    color: white;
}
</style>
</head>
<body>

<form action="/userAccount">
    <input type="submit" value="Edit Account" />
</form>
</div>
    <div>
    	<br>
    	<form action="/logout" method="POST">
    		<input type="submit" value="Logout" />
    	 </form>
    </div>
<div>
Search Books
<form action="books/search" method="POST" modelAttribute="registerForm">

</form>
</div>
<br>
<div>
<table id="books">
    <thead>
        <tr>
            <th>Title</th>
            <th >Author</th>
            <th>Genre</th>
            <th >Amount</th>
            <th >Price</th>
            <th >Rating</th>
            <th>Reviews</th>
            <th>Leave a Review</th>
            <th>Amount to Buy</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.amount}</td>
                <td>${book.price}</td>
                <td>${book.rating}</td>
                <td><a href="/reviews/${book.id}">Show all Published Reviews</a></td>
                <td>
                <form action="edit-review/${book.id}" method="GET">
                	<input type="hidden" name="bookId" value=${book.id} />
                	<input type="submit" value="Leave a Review" />
                </form>
                </td>
                <td>
                <form action="basket/add" method="POST">
                <input name="quantityToAdd" />
                <input type="hidden" name="bookId" value=${book.id} />
                <input type="submit" value="Add to Basket" />
                </form>
                </td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</div>
<br>
<div>
</body>
</html>