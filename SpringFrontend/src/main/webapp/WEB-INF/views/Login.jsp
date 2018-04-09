<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>This is  our  login page.</h1>
<form action="perform_login" method="post">
<table align="center">
<tr>
<td colspan="2"><center>Login credential</center></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"/></td>

</tr>
<tr>
<td colspan="2"><input type="submit" value="SUBMIT"/></td>
</tr>
</table>
</form>
</body>
</html>