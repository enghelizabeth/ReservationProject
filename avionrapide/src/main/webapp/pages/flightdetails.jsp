<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="jqueryFunctions.js"></script>
<script src="errormessages.js"></script>
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


	<h1 class="text-center" style="line-height: 130px">Let Us Get You
		To Your Next Destination!</h1>

	<h2 class="text-center">Where Can We Take You?</h2>
	<div class="container-fluid">
		<form method="post" action="flightdetails"
			onsubmit="return validateFlightDetails();" id="flightDetailsForm">
			<!-- class="formBox" -->

			<div class="row" style="font-size: 20px">
				<strong>Depart:</strong>
			</div>
			<div class="row align-items-center">
				<div class="col-3 colPadding">
					<label for="oac">AirportCode: </label> <input type="text"
						name="originAirport" id="oac" placeholder="Departing Airport" />
				</div>
				<div class="col-3 colPadding">
					<label for="oc">City: </label> <input type="text" name="originCity"
						id="oc" placeholder="Departing City" />
				</div>
				<div class="col-3 colPadding">
					<label for="os">State: </label> <input type="text"
						name="originState" id="os" placeholder="Departing State" />
				</div>
				<div class="col-3 colPadding">
					<label for="oz" style="color: white">Zipcode: </label> <input
						type="text" name="originZipcode" id="oz"
						placeholder="Departing Zipcode" />
				</div>
			</div>
			<div class="row">
				<div class="col-3 colPadding" id="originAirportError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a departing airport code.</span>
				</div>
				<div class="col-3 colPadding" id="originCityError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a departing city.</span>
				</div>
				<div class="col-3 colPadding" id="originStateError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a departing state.</span>
				</div>
				<div class="col-3 colPadding" id="originZipcodeError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a departing zipcode.</span>
				</div>
			</div>
			<div class="row" style="font-size: 20px">
				<strong>Arrive:</strong>
			</div>
			<div class="row">
				<div class="col-3 colPadding">
					Airport Code: <input type="text" name="destinationAirport" id="dac"
						placeholder="Arriving Airport" />
				</div>
				<div class="col-3 colPadding">
					City: <input type="text" name="destinationCity" id="dc"
						placeholder="Arriving City" />
				</div>
				<div class="col-3 colPadding" style="color: white">
					State: <input type="text" name="destinationState" id="ds"
						placeholder="Arriving State" />
				</div>
				<div class="col-3 colPadding" style="color: white;">
					Zipcode: <input type="text" name="destinationZipcode" id="dz"
						placeholder="Arriving Zipcode" />
				</div>
			</div>
			<div class="row">
				<div class="col-3 colPadding" id="destinationAirportError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a destination airport code.</span>
				</div>
				<div class="col-3 colPadding" id="destinationCityError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a destination city.</span>
				</div>
				<div class="col-3 colPadding" id="destinationStateError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a destination state.</span>
				</div>
				<div class="col-3 colPadding" id="destinationZipcodeError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a destination zipcode.</span>
				</div>
			</div>
			<div class="row">
				<div class="col-4 colPadding">
					Depart Date: <input type="date" name="departDate" id="dd" />
				</div>
				<div class="col-4 colPadding">
					Return Date: <input type="date" name="returnDate" id="rd" />
				</div>
				<div class="col-4 colPadding">
					Travelers: <input type="text" name="numOfTravelers" id="not"
						placeholder="Number of Travelers" />
				</div>

				<div></div>
			</div>
			<div class="row">
				<div class="col-4 colPadding" id="departingDateError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify departing date.</span>
				</div>
				<div class="col-4 colPadding" id="returningDateError" hidden>
					<span class="text-danger" style="background-color: yellow">Must
						specify a returning date.</span>
				</div>
				<div class="col-4 colPadding" id="numOfTravelersError" hidden>

					<span class="col-4 text-danger" style="background-color: yellow">
						Must specify number of travelers.</span>

				</div>
			</div>
			<div class="row">
				<div class="col-8"></div>
				<input type="submit" value="Let's Book It!"
					class="btn btn-primary col-1"
					style="background-color: black; text: white" />
				<div class="col-3"></div>
			</div>
		</form>
	</div>
	<p class="text-center">
		Flight search instructions: </br>1. Input both airport codes. <strong>OR</strong>
		Input City, State, and Zipcode for departing and arriving.</br>2. Departing
		and returning date are <strong>required</strong>.</br>3. Number of
		travelers is <strong>required</strong>.
	</p>

	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>


</body>
</html>