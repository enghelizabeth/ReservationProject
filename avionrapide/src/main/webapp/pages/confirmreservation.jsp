<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Reservation</title>
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



	<h1 class="text-center" style="line-height: 130px">Review Flight
		Details</h1>

	<div class="container-fluid" style="background-color: #edb58a">
		<form action="confirmreservation" method="post">
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3">First Name:</div>
				<div class="col">
					<c:out value="${person.firstName}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3">Last Name:</div>
				<div class="col">
					<c:out value="${person.lastName}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Email:</div>
				<div class="col">
					<c:out value="${person.email}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Phone:</div>
				<div class="col">
					<c:out value="${person.phone}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Departing:</div>
				<div class="col">
					<c:out value="${flightInfo.originAirportCode}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Depart Date:</div>
				<div class="col">
					<c:out value="${departingFlight.departDate}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Depart Time:</div>
				<div class="col">
					<c:out value="${departingFlight.departTime}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Arriving:</div>
				<div class="col">
					<c:out value="${flightInfo.destinationAirportCode}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Return Date:</div>
				<div class="col">
					<c:out value="${returningFlight.departDate}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Return Time:</div>
				<div class="col">
					<c:out value="${returningFlight.departTime}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Number of Travelers:</div>
				<div class="col">
					<c:out value="${flightInfo.numOfTravelers}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Depart Flight Cost:</div>
				<div class="col">
					$<c:out value="${departingFlight.ticketCost}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Return Flight Cost:</div>
				<div class="col">
					$<c:out value="${returningFlight.ticketCost}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Total Tax Per Ticket (7.5%):</div>
				<div class="col">
					$<c:out value="${flightInfo.taxCost}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-3"></div>
				<div class="col-3 ">Total Cost:</div>
				<div class="col">
					$<c:out value="${flightInfo.totalCost}"></c:out>
				</div>
			</div>
			<div class="row">
				<div class="col-9"></div>
				<div class="col-3">
					<input type="submit" value="Confirm Flight!"
						class="btn btn-primary">
				</div>
			</div>
		</form>
	</div>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>