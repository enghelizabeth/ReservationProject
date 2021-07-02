package com.skillstorm.avionrapide.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import com.skillstorm.avionrapide.data.AirportDAO;
import com.skillstorm.avionrapide.data.AirportDAOImpl;
import com.skillstorm.avionrapide.data.FlightDAO;
import com.skillstorm.avionrapide.data.FlightDAOImpl;
import com.skillstorm.avionrapide.models.Airport;
import com.skillstorm.avionrapide.models.Flight;

public class FlightService {

	FlightDAO flightDao = new FlightDAOImpl();
	AirportDAO airportDao = new AirportDAOImpl();

	public int getAirportId(String airportCode, String city, String state, int zipcode) {
		Airport tempAirport;
		if (airportCode == null) {
			tempAirport = airportDao.findAirport(city, state, zipcode);
		} else {
			tempAirport = airportDao.findAirportByCode(airportCode);
		}
		return tempAirport.getAirportId();
	}
	
	public List<Flight> getFlights(int originAirportId, int destinationAirportId, LocalDate departDate){
		
		List<Flight> flights = flightDao.findAllFlights(originAirportId, destinationAirportId, departDate);
		return flights;
	}
	
	public String getAiportCode(int airportId) {
		Airport tempAP = airportDao.findAirportById(airportId);
		
		return tempAP.getAirportCode();
	}
	
	public Flight getFlight(int flightNumber){
		Flight flight = flightDao.findFlightByNumber(flightNumber);
		
		return flight;
	}

	public BigDecimal totalTaxCost(BigDecimal departCost, BigDecimal returnCost) {
		System.out.println("in tax cost");
		BigDecimal taxCost = new BigDecimal(0);
		BigDecimal taxRate = new BigDecimal(.075);
		taxCost = taxCost.add(departCost);
		taxCost = taxCost.add(returnCost);
		taxCost = taxCost.multiply(taxRate);
		taxCost = taxCost.setScale(2, BigDecimal.ROUND_UP);
		return taxCost;
	}
	
	public BigDecimal totalTicketCost(BigDecimal departCost, BigDecimal returnCost, BigDecimal taxCost, int numTravs) {
		System.out.println("in ticket cost");
		BigDecimal ticketCost = new BigDecimal(0);
		System.out.println(ticketCost);
		ticketCost = ticketCost.add(departCost);
		System.out.println(ticketCost);
		ticketCost = ticketCost.add(returnCost);
		System.out.println(ticketCost);
		ticketCost = ticketCost.add(taxCost);
		System.out.println(ticketCost);
		ticketCost= ticketCost.multiply(BigDecimal.valueOf(numTravs));
		ticketCost = ticketCost.setScale(2, BigDecimal.ROUND_UP);
		return ticketCost;
	}
	
}
