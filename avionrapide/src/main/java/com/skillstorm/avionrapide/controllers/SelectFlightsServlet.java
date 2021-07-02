package com.skillstorm.avionrapide.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.avionrapide.models.Flight;
import com.skillstorm.avionrapide.models.Reservation;
import com.skillstorm.avionrapide.models.TempModelForFlightDetails;
import com.skillstorm.avionrapide.services.FlightService;

/**
 * This servlet takes the information from last page Gets all available flights
 * based on criteria User selects the flights they would like to take on this
 * page
 */
@WebServlet("/pages/selectflights")
public class SelectFlightsServlet extends HttpServlet {

	/**
	 * this happens after selecting flights
	 */
	FlightService fService = new FlightService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation reservation = new Reservation();
		TempModelForFlightDetails flightInfo = (TempModelForFlightDetails) req.getSession().getAttribute("flightInfo");
		int departingFlightNumber = Integer.parseInt(req.getParameter("selectedDepartingFlightNumber"));
		int returningFlightNumber = Integer.parseInt(req.getParameter("selectedReturningFlightNumber"));

		reservation.setDepartingFlightNumber(departingFlightNumber);
		reservation.setReturningFlightNumber(returningFlightNumber);
		reservation.setNumSeatsBooked(flightInfo.getNumOfTravelers());
		Flight selectedDepartingFlight = fService.getFlight(departingFlightNumber);
		Flight selectedReturningFlight = fService.getFlight(returningFlightNumber);
		flightInfo.setTaxCost(fService
				.totalTaxCost(selectedDepartingFlight.getTicketCost(), (selectedReturningFlight.getTicketCost())));
		flightInfo.setTotalCost(fService.totalTicketCost(selectedDepartingFlight.getTicketCost(),
				selectedReturningFlight.getTicketCost(), flightInfo.getTaxCost(), flightInfo.getNumOfTravelers()));

		//req.getSession().removeAttribute("departingFlights");
		//req.getSession().removeAttribute("returningFlights");
		req.getSession().setAttribute("reservation", reservation);
		req.getSession().setAttribute("flightInfo", flightInfo);
		req.getSession().setAttribute("departingFlight", selectedDepartingFlight);
		req.getSession().setAttribute("returningFlight", selectedReturningFlight);
		resp.sendRedirect("customerdetails.jsp");
	}
}
