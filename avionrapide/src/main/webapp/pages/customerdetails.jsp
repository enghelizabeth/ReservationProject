<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<script type="text/javascript" src="/pages/errormessages.js"></script>
<link rel="stylesheet" href="./styles/styling.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div id="nav-placeholder"></div>

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

	<h1 class="text-center" style="line-height: 130px">Enter Your
		Information</h1>

	<div class="container-fluid">
		<form action="customerdetails" method="post" style="background-color:#edb58a">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-2 colPadding">First Name:</div>
				<div class="col">
					<input type="text" name="firstName" required />
				</div>
			</div>
			<div class="row ">
				<div class="col-4"></div>
				<div class="col-2 colPadding">Last Name:</div>
				<div class="col">
					<input type="text" name="lastName" required />
				</div>
			</div>
			<div class="row ">
				<div class="col-4"></div>
				<div class="col-2 colPadding">Email:</div>
				<div class="col">
					<input type="text" name="email" required />
				</div>
			</div>
			<div class="row ">
				<div class="col-4"></div>
				<div class="col-2 colPadding">Phone:</div>
				<div class="col">
					<input type="text" name="phone" required />
				</div>
			</div>
			<div class="row ">
				<div class="col-4"></div>
				<div class="col-2 colPadding">Birthdate:</div>
				<div class="col">
					<input type="date" name="birthdate" />
				</div>
			</div>
			<div class="row">
				<div class="col-5"></div>
				<div class="col-4">
					<input type="submit" class="btn btn-primary" value="Review Details">
				</div>
			</div>
		</form>
	</div>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>