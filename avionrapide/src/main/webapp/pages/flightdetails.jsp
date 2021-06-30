<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="jqueryFunctions.js"></script>
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
		<h1 class="text-center" style="line-height: 130px">Let Us Get You
			To Your Next Destination!</h1>
	</div>
	<p class="text-center">Where Can We Take You?</p>
	<form class="formBox" method="post" action="flightdetails">
		<div class="row" style="font-size:20px"><strong>Depart:</strong></div>
		<div class="row">
			<div class="col-3 colPadding">
				AirportCode: <input type="text" id="valueText" name="originAirport" placeholder="Departing Airport"/>
			</div>
			<div class="col-3 colPadding">
				City: <input type="text" name="originCity" placeholder="Departing City"/>
			</div>
			<div class="col-3 colPadding">
				State: <input type="text" name="originState" placeholder="Departing State"/>
			</div>
			<div class="col-3 colPadding">
				Zipcode: <input type="text" name="originZipcode" placeholder="Departing Zipcode"/>
			</div>
		</div>
		<div class="row" style="font-size:20px"><strong>Arrive:</strong></div>
		<div class="row">
			<div class="col-3 colPadding">
				Airport Code: <input type="text" name="destinationAirport" placeholder="Arriving Airport"/>
			</div>
			<div class="col-3 colPadding">
				City: <input type="text" name="destinationCity" placeholder="Arriving City"/>
			</div>
			<div class="col-3 colPadding">
				State: <input type="text" name="destinationState" placeholder="Arriving State"/>
			</div>
			<div class="col-3 colPadding">
				Zipcode: <input type="text" name="destinationZipcode" placeholder="Arriving Zipcode"/>
			</div>
		</div>
			<div class="row">
				<div class="col-3 colPadding">
					Depart Date: <input type="date" name="departDate" />
				</div>
				<div class="col-3 colPadding">
					Return Date: <input type="date" name="returnDate" />
				</div>
				<div class="col-3 colPadding">
					Travelers: <input type="text" name="numOfTravelers" placeholder="Number of Travelers"/>
				</div>
				<div class="col-3 colPadding"></div>
					<div>
					
				</div>
			</div>
			<input type="submit" value="Let's Book It!" class="btn btn-primary" />
	</form>

	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>


</body>
</html>