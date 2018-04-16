<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>


<body>
	<div style = "text-align:center">
	<h1>Book Store Login</h1>
	</div>
		<form id='login-form' action="/login" method="POST">
  			<input name="username" type="text" placeholder="Username" required>
  			<input name="password" type="password" placeholder="Password" required>
  			<button type='submit'>Login</button>
			<a href="<c:url value='/register' />">Not Registered ? Register Now</a>		
		</form>
</body>
</html>