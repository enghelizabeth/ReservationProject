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
@WebServlet({"/flightdetails"})
public class FlightDetailsServlet extends HttpServlet {
	
	FlightService flightService = new FlightService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Worked");
		
		/*TempModelForFlightDetails flightInfo = new TempModelForFlightDetails();
		flightInfo.setOriginAirportId(flightService.getAirportId(null, req.getParameter("originCity"), 
				req.getParameter("originState"), Integer.parseInt(req.getParameter("originZipcode"))));
		flightInfo.setDestinationAirportId(flightService.getAirportId(null, req.getParameter("destinationCity"), 
				req.getParameter("destinationState"), Integer.parseInt(req.getParameter("destinationZipcode"))));
		flightInfo.setDepartDate(LocalDate.parse(req.getParameter("departDate")));
		flightInfo.setReturnDate(LocalDate.parse(req.getParameter("departDate")));
		
		//System.out.println(flightInfo);
		//req.getRequestDispatcher("selectflights.jsp").forward(req, resp);*/
		resp.sendRedirect("/selectflights.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet");
	}
}
