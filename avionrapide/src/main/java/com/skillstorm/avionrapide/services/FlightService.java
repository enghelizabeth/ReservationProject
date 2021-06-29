package com.skillstorm.avionrapide.services;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.avionrapide.data.AirportDAO;
import com.skillstorm.avionrapide.data.AirportDAOImpl;
import com.skillstorm.avionrapide.data.FlightDAO;
import com.skillstorm.avionrapide.data.FlightDAOImpl;
import com.skillstorm.avionrapide.models.Airport;

public class FlightService {

	FlightDAO flightDao = new FlightDAOImpl();
	AirportDAO airportDao = new AirportDAOImpl();

	public int getAirportId(String airportCode, String city, String state, int zipcode) {
		Airport tempAirport = airportDao.findAirport(city, state, zipcode);
		return tempAirport.getAirportId();
	}

}
