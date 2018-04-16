<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Book Function</title>
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

#books {
    font-family: " Aria;
    border-collapse: collapse;
    width: 100%;
}

#books td, #customers th {
    border: 10px solid ;
    padding: 10px;
}

#books th {
    padding-top: 15px;
    padding-bottom: 15px;
    text-align: left;
}
</style>

<body>

<div>
<table id="books">
    <thead>
        <tr>
         	
            <th >Title</th>
            <th >Author</th>
            <th >Genre</th>
            <th >Amount</th>
            <th >Price</th>
            <th >Rating</th>
            <th>Add Stock</th>
            <th >Image</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
             	<td><img src="/book/imageDisplay?id=${book.id}" height="50" width="50"/></td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.amount}</td>
                <td>${book.price}</td>
                <td>${book.review}</td>
                <td>
                	<form action="/admin/updateAmount" method="POST">
                		<input name="updateAmount" />
                		<input type="hidden" name="bookId" value=${book.id} />
                		<input type="submit" value="Update Amount Available" />
                	</form>
                </td>
            </tr>       
        </c:forEach>
    </tbody>
</table>
</div>
<div>
<br>
 <form action="/admin/addbook">
    <input type="submit" value="Add Book" />
 </form>
</div>
<div>
<br>
 <form action="/admin/users">
    <input type="submit" value="View Users" />
 </form>
      <div>
</body>
</html>