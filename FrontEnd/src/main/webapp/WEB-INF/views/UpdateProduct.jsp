<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Product</title>
</head>
<body>
<h1>This is the UpdateProduct page.</h1>
<form:form action="updateProduct" modelAttribute="product" method="post">

<form:input path="productId" readonly="readonly" value="${productInfo.productId}"/><br/>
<form:input path="productName" value="${productInfo.productName}"/><br/>
<form:input path="productDesc" value="${productInfo.productDesc}"/><br/>
<form:input path="supplierId" value="${productInfo.supplierId}"/><br/>
<form:input path="categoryId" value="${productInfo.categoryId}"/><br/>
<form:input path="price" value="${productInfo.price}"/><br/>
<form:input path="stock" value="${productInfo.stock}"/><br/>
<button type="submit" class="btn">Update</button>
</form:form>
</body>
</html>