<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetail </title>
</head>
<body>
<h3 align="center">  this is UserDetail page</h3>
<form action="InsertUserDetail" method="post">
<table align ="center"></table>
<table>
<tr><td colspan="2">UserDetail Detail</td></tr>
<tr>
<td> User Name</td>
<td><input type="text" name="username" id="useraddr"/></td>
</tr>
<tr bgcolor="pink">
<td>product addr</td>
<td>
<textarea name="useraddr" id="useraddr">
</textarea>
</td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="SUBMIT"/></center>
</td>



</table></form>
<table align="center">
<tr bgcolor="cyan">
<td>User Name</td>
<td>user emailId</td>
<td>Product Address</td>
<td>Operation</td>
</tr>

<c:forEach items="${userList}" var="user">
<tr>
<td>${user.userNamr}</td>
<td>${user.emailId}</td>
<td>${user.address}</td>
<td>
<a href="<c:url value='/edituser/${user.userName}'/>">Edit</a> 
<a href="<c:url value='/deleteuser/${user.userName}'/>">Delete</a> 

</td>
<td>

</td>
</tr>

</c:forEach>
</table>

</body>
</html>