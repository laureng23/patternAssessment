<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<h2>User login</h2>
    <form action="/login" method="POST">
        <<div style="width: 150px; text-align:centre;">
            <div style="padding:20px;">
                  Username: <input name="username" />
            </div>
           <div style="padding:20px;">
                Password: <input type="password" name="password" />
            </div>
            <div style="padding:20px;text-align:center">
                <input type="submit" value="Submit" />
            </div>
        </div>
        	<a href="<c:url value='/register' />">Not Registered ? Register Now</a>		
        
    </form>
   
</body>
</html>