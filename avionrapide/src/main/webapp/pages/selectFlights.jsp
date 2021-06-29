<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Departing Flight</title>
<link rel="stylesheet" href="styling.css">
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
	<!--  <div><img src="c:url value='/images/ARlogo.png'"/></div> -->
	<div>
	
		<form  action="returningFlight" method="post">
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
					<tr>
						<td>1234</td>
						<td>PHX</td>
						<td>MOT</td>
						<td>08/21/2021</td>
						<td>8:00</td>
						<td><input type="submit" value="Let's Fly"
							class="btn btn-primary" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<footer class="footer">
		<p>Disclaimer: No refunds.</p>
	</footer>
</body>
</html>