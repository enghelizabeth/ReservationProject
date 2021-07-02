package com.skillstorm.avionrapide.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.avionrapide.models.Flight;
import com.skillstorm.avionrapide.models.TempModelForFlightDetails;
import com.skillstorm.avionrapide.services.FlightService;

@WebServlet("/pages/loadflights")
public class LoadFlightsServlet extends HttpServlet {

	FlightService service = new FlightService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			TempModelForFlightDetails flightInfo = (TempModelForFlightDetails) req.getSession()
					.getAttribute("flightInfo");
			List<Flight> departingFlights = service.getFlights(flightInfo.getOriginAirportId(),
					flightInfo.getDestinationAirportId(), flightInfo.getDepartDate());
			List<Flight> returningFlights = service.getFlights(flightInfo.getDestinationAirportId(),
					flightInfo.getOriginAirportId(), flightInfo.getReturnDate());

			req.getSession().setAttribute("departingFlights", departingFlights);
			req.getSession().setAttribute("returningFlights", returningFlights);

			// System.out.println(departingFlights);
			// System.out.println(returningFlights);
			resp.sendRedirect("selectflights.jsp");
			
		
	
	}

}
