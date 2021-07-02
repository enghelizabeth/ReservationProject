<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>You're all booked</title>
<link rel="stylesheet" href="./styles/styling.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #5d57d9">
		<a class="navbar-brand" href="flightdetails.jsp"> <img
			src="<c:url value='/images/logo.png'/>" alt="Avion Rapide Logo"
			width="70" height="70" />
		</a> <a class="navbar-brand" href="#"><Strong>Avion Rapide</Strong></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="">Home
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Features</a>
				</li>
			</ul>
		</div>
	</nav>


	<h1 class="text-center" style="line-height: 130px">Thank You For
		Trusting Avion Rapide</h1>

	<div class="container-fluid" style="background-color: yellow">
		<p style="text-align: center">
			Congrats
			<c:out value="${person.firstName}"></c:out>
			!
		</p>
		<p style="text-align: center">

			Confirmation Number:
			<c:out value="${reservation.confirmationNumber}"></c:out>
		</p>
		<p style="text-align: center">
			A confirmation email will be sent to
			<c:out value="${person.email}"></c:out>
			.
		</p>
	</div>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>