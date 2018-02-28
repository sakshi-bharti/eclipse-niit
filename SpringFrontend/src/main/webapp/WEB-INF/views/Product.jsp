<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="Header.jsp" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
<h3 align="center">  this is Product page</h3>
<form:form action="InsertProduct" modelAttribute="product" method="post">
<table align ="center"></table>
<table>
<tr bgcolor="olive">
<td colspan="2"><center>Product form</center></td>
</tr>
<tr>
<td>Product Name</td>
<td><form:input path="productName"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td>Stock</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td>Category</td>
<td><form:input path="CategoryId"/></td>
</tr>
<tr>
<td>Supplier</td>
<td><form:input path="supplierId"/>
</td>
</tr>
<tr>
<td>Product Description</td>
<td><form:input path="productDesc"/></td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="SUBMIT"/></center>
</td>
</tr>


</table>
<table align="center">
<tr bgcolor="cyan">
<td>Product Id</td>
<td>Product Name</td>
<td>Product Desc</td>
<td>Supplier Id</td>
<td>Category Id</td>
<td>Price</td>
<td>stock</td>
<td>Operation</td>
</tr>

<c:forEach items="${listProducts}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productDesc}</td>
<td>${product.supplierId}</td>
<td>${product.categoryId}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>edit/delete</td>

<td>
<a href="<c:url value='/editProduct/${product.productId}'/>">Edit</a> 
<a href="<c:url value='/deleteProduct/${product.productId}'/>">Delete</a> 

</td>
<td>

</td>
</tr>

</c:forEach>
</table>
</form:form>
</body>
</html>