<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DisplayProducts</title>
</head>
<body>	
<h2><marquee>Mobiles</marquee></h2>
   
    
    <div class="container">
    <div class="row">
    
    <c:forEach items="${listProducts}" var="product">
     <div class="col-sm-6 col-md-3"> 
     	
    	
      <a href="<c:url value='ProductDesc/${product.productId}'/>" class="thumbnail">
      <img src='<c:url value="/resources/images/${product.productId}.jpg" />' alt="Products" style="width:100%"/>
      </a>
      <h4>${product.productName}</h4>
      <p>Price:${product.price}</p>
      
      </div>  
 </c:forEach>
    </div>
    </div> 
</body>
</html>