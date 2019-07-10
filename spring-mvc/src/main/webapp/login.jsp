<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body style="color:blue;align:center">
<b> ${message}</b>
<form method="post" action = "login.lti">

Enter username: <input type ="text" name="username"/><br/>
Enter passowrd: <input type="password"  name="password" /> <br/>
<button type="submit"> Login</button>
</form>

</body>
</html>