<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Departing Flight</title>
<link rel="stylesheet" href="./styles/styling.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid"
		style="background-color: #0099ff; height: 100px">
		<!-- <div class="col-1"><img src="c:url value='/images/ARlogo.png'"/>
		</div>-->
		<div class="col-11">
			<h1 class="text-center" style="line-height: 130px">Pick Your
				Departing Flight</h1>
		</div>
	</div>
	<form action="pleaseselectflights" method="post">
		<div>
			<h2>Select Departing Flight</h2>

			<table class="table table-hover table-dark table-striped">
				<thead>
					<tr style="background-color: #33adff">

						<th>Flight Number</th>
						<th>Departing From</th>
						<th>Flying To</th>
						<th>Depart Date</th>
						<th>Depart Time</th>
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
							<td><input type="checkbox"
								name="selectedDepartedFlightNumber"
								value="${flight.flightNumber}"></td>
							<!--<td><input type="submit" value="Let's Fly"
								class="btn btn-primary" /></td>-->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h2>Select Returning Flight</h2>
			<table class="table table-hover table-dark table-striped">
				<thead>
					<tr style="background-color: #33adff">

						<th>Flight Number</th>
						<th>Departing From</th>
						<th>Flying To</th>
						<th>Depart Date</th>
						<th>Depart Time</th>
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
							<td><input type="checkbox"
								name="selectedDepartedFlightNumber"
								value="${flight.flightNumber}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="submit" value="Let's Fly" class="btn btn-primary" />
	</form>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>