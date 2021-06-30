package com.skillstorm.avionrapide.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.avionrapide.models.Flight;
import com.skillstorm.avionrapide.models.TempModelForFlightDetails;
import com.skillstorm.avionrapide.services.FlightService;

/**
 * User filled out criteria for a flight they would like to take
 * Need to save the data and send to next page to load available flights
 *
 */
@WebServlet("/pages/flightdetails")
public class FlightDetailsServlet extends HttpServlet {
	
	FlightService flightService = new FlightService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int originZipcode, destinationZipcode;
		
		if(req.getParameter("originZipcode")== "") {
			originZipcode = 0;
		}else {
			originZipcode = Integer.parseInt(req.getParameter("originZipcode"));
		}
		if(req.getParameter("destinationZipcode")== "") {
			destinationZipcode = 0;
		}else {
			destinationZipcode = Integer.parseInt(req.getParameter("destinationZipcode"));
		}
		
		TempModelForFlightDetails flightInfo = new TempModelForFlightDetails();
		flightInfo.setOriginAirportId(flightService.getAirportId(req.getParameter("originAirport"), req.getParameter("originCity"), 
				req.getParameter("originState"), originZipcode));
		flightInfo.setDestinationAirportId(flightService.getAirportId(req.getParameter("destinationAirport"), req.getParameter("destinationCity"), 
				req.getParameter("destinationState"), destinationZipcode));
		flightInfo.setDepartDate(LocalDate.parse(req.getParameter("departDate")));
		flightInfo.setReturnDate(LocalDate.parse(req.getParameter("returnDate")));
		flightInfo.setNumOfTravelers(Integer.parseInt(req.getParameter("numOfTravelers")));
		
		//System.out.println(flightInfo);
		req.getSession().setAttribute("flightInfo", flightInfo);
		resp.sendRedirect("loadflights");
		//req.getRequestDispatcher("loadflights").forward(req, resp);
	}
}
