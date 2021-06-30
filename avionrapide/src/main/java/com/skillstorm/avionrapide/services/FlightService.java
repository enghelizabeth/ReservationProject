package com.skillstorm.avionrapide.services;

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

}
