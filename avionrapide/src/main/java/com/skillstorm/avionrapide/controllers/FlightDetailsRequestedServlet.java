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

@WebServlet(urlPatterns = "/flightdetails")
public class FlightDetailsRequestedServlet extends HttpServlet {
	
	FlightService flightService = new FlightService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Worked");
		/*String originCity = (String) req.getSession().getAttribute("originCity");
		String originState = (String) req.getSession().getAttribute("originState");
		int originZipcode = (int) req.getSession().getAttribute("originZipcode");
		String destinationCity = (String) req.getSession().getAttribute("destinationCity");
		String destinationState = (String) req.getSession().getAttribute("destinationState");
		int destinationZipcode = (int) req.getSession().getAttribute("destinationZipcode");*/
		
		/*TempModelForFlightDetails flightInfo = new TempModelForFlightDetails();
		flightInfo.setOriginAirportId(flightService.getAirportId(null, req.getParameter("originCity"), 
				req.getParameter("originState"), Integer.parseInt(req.getParameter("originZipcode"))));
		flightInfo.setDestinationAirportId(flightService.getAirportId(null, req.getParameter("destinationCity"), 
				req.getParameter("destinationState"), Integer.parseInt(req.getParameter("destinationZipcode"))));
		flightInfo.setDepartDate(LocalDate.parse(req.getParameter("departDate")));
		flightInfo.setReturnDate(LocalDate.parse(req.getParameter("departDate")));
		/*flightInfo.setOriginAirportId(
				flightService.getAirportId(null, (String) req.getSession().getAttribute("originCity"),
						(String) req.getSession().getAttribute("originState"), (int) req.getSession().getAttribute("originZipcode")));
		flightInfo.setDestinationAirportId(
				flightService.getAirportId(null, destinationCity, destinationState, destinationZipcode));
		flightInfo.setDepartDate((LocalDate) (req.getSession().getAttribute("departDate")));
		flightInfo.setReturnDate((LocalDate) (req.getSession().getAttribute("returnDate")));*/
		//System.out.println(flightInfo);
		//req.getRequestDispatcher("selectflights.jsp").forward(req, resp);
		resp.sendRedirect("/selectflights.jsp");
	}
}
