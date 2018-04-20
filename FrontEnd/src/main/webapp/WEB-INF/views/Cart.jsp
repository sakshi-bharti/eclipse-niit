<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <div class="container">
   
   <table align="center" class="table">
		<tr bgcolor="olive">
			<td>Product Id</td>
			<td>Product Name</td>>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${cartItems}" var="cartItem">
			<tr>
			<form action="<c:url value="/updateCart/${cartItem.cartItemId}"/>" method="get">
				<td>${cartItem.productId}</td>
				<td>${cartItem.productName}</td>
				<td><input type="text" value="$cartItem.quantity}" name="quantity"/></td>
				<td>${cartItem.price}</td>
				<td>${cartItem.price*cartitem.quantity}</td>
				<td>
				<input type="submit" value="Update" class="btn btn-success btn-block"/>
				</td>
				<tr bgcolor="olive">
				<td colspan="4">Total amount</td>
				<td colspan="2">${totalAmount}</td>
				</tr>
				</form>				
			</c:forEach>
			</table>
			</div>