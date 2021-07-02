<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Departing Flight</title>
<script src="selectflighterror.js"></script>
<script src="jqueryFunctions.js"></script>
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


	<h1 class="text-center" style="line-height: 130px;"">Pick Your
		Departing Flight</h1>

	<form action="selectflights" method="post"
		onsubmit="return sufficientflightsselected();" id="selectFlightsForm">
		<div>
			<h2>Select Departing Flight</h2>
			<div class="col-3 colPadding" id="departFlightSelectedError" hidden>
				<span class="text-danger" style="background-color: yellow">Must
					select <strong>one</strong> departing flight!
				</span>
			</div>

			<table class="table table-hover table-dark table-striped">
				<thead>
					<tr>
						<th>Flight Number</th>
						<th>Departing From</th>
						<th>Flying To</th>
						<th>Depart Date</th>
						<th>Depart Time</th>
						<th>Seats Available</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="flight" items="${departingFlights}">
						<tr>
							<td><c:out value="${flight.flightNumber}"></c:out></td>
							<td><c:out value="${flight.originAirportId}"></c:out></td>
							<td><c:out value="${flight.destinationAirportId}"></c:out></td>
							<td><c:out value="${flight.departDate}"></c:out></td>
							<td><c:out value="${flight.departTime}"></c:out></td>
							<td><c:out value="${flight.seatsAvailable}"></c:out></td>
							<td><input type="checkbox"
								name="selectedDepartingFlightNumber"
								value="${flight.flightNumber}" id="departCheckbox"></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h2 style="background-color: #edb58a">Select Returning Flight</h2>
			<table class="table table-hover table-dark table-striped">
				<thead>
					<tr>

						<th>Flight Number</th>
						<th>Departing From</th>
						<th>Flying To</th>
						<th>Depart Date</th>
						<th>Depart Time</th>
						<th>Seats Available</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="flight" items="${returningFlights}">
						<tr>
							<td><c:out value="${flight.flightNumber}"></c:out></td>
							<td><c:out value="${flight.originAirportId}"></c:out></td>
							<td><c:out value="${flight.destinationAirportId}"></c:out></td>
							<td><c:out value="${flight.departDate}"></c:out></td>
							<td><c:out value="${flight.departTime}"></c:out></td>
							<td><c:out value="${flight.seatsAvailable}"></c:out></td>
							<td><input type="checkbox"
								name="selectedReturningFlightNumber"
								value="${flight.flightNumber}" id="returnCheckbox"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-8"></div>
			<div class="col-3">
				<input type="submit" value="Let's Fly" class="btn btn-primary" />
			</div>
		</div>
	</form>
	<div class="row">
		<p>.</p>
	</div>
	<div class="row">
		<p>.</p>
	</div>
	<div class="row">
		<p>.</p>
	</div>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>