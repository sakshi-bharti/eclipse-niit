<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
#upperlabel
{
background-color:orange;
}
</style>
</head>


<body>
<div id="upperlabel" class="container-fluid">
<label>Social Icon</label></div>

<div class="container">
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">Home Interior</a>
</div>
<c:if test="${!sessionScope.loggedIn}">
<ul class="nav navbar-nav">
<li><a href="#">Home</a>
<li><a href="Login">Login</a></li>
<li><a href="Register">Register</a></li>
<li><a href="AboutUs">AboutUs</a></li>
<li><a href="ContactUs">ContactUs</a></li>
<li><a href="Signup">Signup</a></li>
</ul>
</c:if>
<c:if test="${sessionScope.loggedIn}">
      <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
      <ul class="nav navbar-nav">
      <li><a href="#">Home</a>
      <li><a href="Category">Category</a></li>
      <li><a href="Product">Product</a></li>
      <li><a href="logout">logout</a></li>
      </ul>
      </c:if>
      <c:if test="${sessionScope.role=='ROLE_USER' }">
      <ul class="nav navbar-nav">
      <li><a href="#">Home</a>
      <li><a href="Cart">${cartsize}</a><span class="glyphicon glyphicon-shopping-cart"></span></li>
      <li><a href="logout">logout</a></li>
      </ul>
      </c:if>
      </c:if>
      </div>
</nav>
</div>
<center>
<a href="Login">Login</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="Register">Register</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="Signup">Signup</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="AboutUs">About Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="ContactUs">Contact Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="Category">Category </a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="Supplier">Supplier </a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="Product">Product </a>&nbsp;&nbsp;|&nbsp;&nbsp;

</center>
</body>
</html>
