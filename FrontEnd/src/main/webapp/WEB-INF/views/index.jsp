<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Gadget-Guru</title>

<style>
.dropdown {
	position: relative;
	display: inline-block;
}
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}
.dropdown-content a:hover {
	background-color: #f1f1f1
}
.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>

<body>

	<!-- Navigation -->
	<%@include file="Header.jsp"%>

	<!-- Page Content -->
	<div class="container">

		<!-- Heading Row -->
		<div class="row my-4">
			<div class="col-lg-8">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">

					<ol class="carousel-indicators">

						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>

					</ol>
					<div class="carousel-inner">

						<div class="item active">
							<img class="img-responsive center block"
								src="<spring:url value="/resources/images/slide1.jpg/"/>"
								alt="first slide">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img class="img-responsive center block"
								src="<spring:url value="/resources/images/slide2.jpg/"/>"
								alt="Second slide">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img class="img-responsive center block"
								src="<spring:url value="/resources/images/slide3.jpg/"/>"
								alt="Third slide">
							<div class="carousel-caption"></div>
						</div>

					</div>
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

			</div>
