<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplier</title>
</head>
<body>
<h3 align="center">  this is supplier page</h3>
<form action="InsertSupplier" method="post">
<table align ="center"></table>
<table>
<tr><td colspan="2">Supplier Detail</td></tr>
<tr>
<td> Supplier Name</td>
<td><input type="text" name="supname" id="supaddr"/></td>
</tr>
<tr bgcolor="pink">
<td>supplier address</td>
<td>
<textarea name="supaddr" id="supaddr">
</textarea>
</td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="Update"/></center>
</td>



</table></form>
<table align="center">
<tr bgcolor="cyan">
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>supplier Desc</td>
<td>Operation</td>
</tr>

<c:forEach items="${supplierList}" var="supplier">
<tr>
<td>${supplier.supplierId}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierAddrs}</td>
<td>
<a href="<c:url value='/editSupplier/${supplier.supplierId}'/>">Edit</a> 
<a href="<c:url value='/deleteSupplier/${supplier.supplierId}'/>">Delete</a> 

</td>
<td>

</td>
</tr>

</c:forEach>
</table>
</body>
</html>