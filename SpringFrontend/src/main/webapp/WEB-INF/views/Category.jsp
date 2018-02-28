<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category</title>
</head>
<body>
<h3 align="center">  this is category page</h3>
<form action="InsertCategory" method="post">
<table align ="center"></table>
<table>
<tr><td colspan="2">category Detail</td></tr>
<tr>
<td> category Name</td>
<td><input type="text" name="catname" id="catdesc"/></td>
</tr>
<tr bgcolor="pink">
<td>category Desc</td>
<td>
<textarea name="catdesc" id="catdesc">
</textarea>
</td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="SUBMIT"/></center>
</td>



</table>
</form>
<table align="center">
<tr bgcolor="cyan">
<td>Category ID</td>
<td>Category Name</td>
<td>Category Desc</td>
<td>Operation</td>
</tr>

<c:forEach items="${categoryList}" var="category">
<tr>
<td>${category.categoryid}</td>
<td>${category.categoryname}</td>
<td>${category.categorydesc}</td>
<td>
<a href="<c:url value='/editCategory/${category.categoryid}'/>">Edit</a> 
<a href="<c:url value='/deleteCategory/${category.categoryid}'/>">Delete</a> 

</td>
<td>

</td>
</tr>

</c:forEach>
</table>
</body>
</html>