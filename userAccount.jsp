<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Account</title>

</head>
<body>
<div style="padding-left:50px;font-family:monospace;">
        <h2>User Account</h2>
        User: ${currentUser.username},${currentUser.paymentMethod}
        <form action="/edit-account" method="POST">
            <div style="width: 100px; text-align:left;">
                <div style="padding:10px;">
                    Address: <textarea name="address" cols="40" rows="9">${currentUser.address}</textarea>
                </div>
                <div style="padding:10px;">
                    Pay by
                    <select name="payment" id="payment">
  						<option value="payPal">PayPal</option>
  						<option value="card">Card </option>
  						
					</select>
                </div>
                <div style="padding-left:10px;">
                    <input type="submit" value="Submit" />
                </div>
            </div>
        </form>
    </div>
   
</body>
</html>