<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>order Page</title>
<style type="text/css">
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
/*     border: 1px solid #ddd; */
}
th, td {
    text-align: left;
    padding: 8px;
}
input {
	text-align: center;
}
#grad1 {
    height: 50px;
   	background: orange; /* For browsers that do not support gradients */ 
    background: linear-gradient(to right, rgba(0,128,128,0), rgba(0,128,128,1)); /* Standard syntax (must be last) */
}
</style>
</head>
<body>
<div class="container">
<h1 id="grad1">Your Order </h1>
<div class="row my-4">
<div class="col-lg-4">

</div>
<div class="col-lg-8">
<form action="proceed" method="post">
<div style="overflow-x:auto;">
  <table class="table table-hover">
 <tr>
			<th>Product Id</th>
			<th>Product Name</th>>
			<th>Quantity</th>
			<th>Price</th>
			<th>Total Price</th>
			<th>Operation</th>
		</tr>

		<c:forEach items="${cartItems}" var="cartItem">
			<tr>
			<form action="<c:url value="/updateCart/${cartItem.cartItemId}"/>" method="get">
				<td>${cartItem.productId}</td>
				<td>${cartItem.productname}</td>
				<td><input type="text" value="${cartItem.quantity}" name="quantity"/></td>
				<td>${cartItem.price}</td>
				<td>${cartItem.price*cartitem.quantity}</td>
				</tr></form>				
			</c:forEach>
			
				<tr>
    	<td colspan="4">Total Amount</td>
    	<td >${totalAmount}/-</td>
    </tr>
     <br>
    <tr>
    	<td>Select Your Mode Of Payment</td>
    	<td><input type="radio" name="pmode" value="COD"/>Cash On Delivery</td>
    	<td><input type="radio" name="pmode" value="NB"/>Net Banking</td>
    	<td><input type="radio" name="pmode" value="CC"/>Credit Card</td>
    	<td><input type="radio" name="pmode" value="DC"/>Debit Card</td>
    </tr>
    <tr>
    	<td colspan="3"><a href="<c:url value="/Cart"/>" class="btn btn-default btn-block">Edit Order</a></td>
    	<td colspan="2"><input type="submit" value="PAY NOW" class="btn btn-info btn-block"/></td>
    </tr>
			</table>
			</div>
			</div>
			</div>
			</div>
			</body>
			
			</html>
		