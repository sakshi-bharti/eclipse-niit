<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <div class="container">
   <table class="table">
   <tr>
   <td rowspan="9">
   <img src="<c:url value="/resources/images${product.productId}.jpg"/>"/>
   </td>
   </tr>
   <tr>
   <td>ProductID</td>
   <td>${product.productId}</td>
   </tr>
   <tr>
   <td>ProductName</td>
   <td>${product.productName}</td>
   </tr>
   <tr>
   <td>SupplierID</td>
   <td>${product.supplierId}</td>
   </tr>
   <tr>
   <td>CategoryId</td>
   <td>${product.categoryId}</td>
   </tr>
   <tr>
   <td>Price</td>
   <td>${product.price}</td>
   </tr>
   <tr>
   <td>Stock</td>
   <td>${product.stock}</td>
   </tr>
   <form action="<c:url value="/addTOCart/${product.productId}"/>" method="get">
      <tr>
   <td>Quantity</td>
   <td><select name="quantity" class="form-control btn-block">
   
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
   <option value="4">4</option>
   <option value="5">5</option>
   </select></td>
   </tr>
   <tr>
   <td colspan="2">
   <input type="submit" value="AddToCart" class="btn btn-danger btn-block">
   </td>
   </tr>
   </form>
   
   </table>
  
 
  
   </div>