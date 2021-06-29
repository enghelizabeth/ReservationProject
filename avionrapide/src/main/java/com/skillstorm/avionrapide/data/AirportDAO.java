package com.skillstorm.avionrapide.data;

import java.util.List;

import com.skillstorm.avionrapide.models.Airport;

public interface AirportDAO {

	String url = "jdbc:mysql://localhost:3306/avionrapide";
	String username = "root";
	String password = "root";
	
	public List<Airport> findAll();
	
	public Airport findAirport(String city, String state, int zipcode);
	
	public Airport findAirportByCode(String airportCode);
	
	public List<Airport> findAirportsByState(String state);
	
	public List<Airport> findAirportsByCity(String city);
	
	public List<Airport> findAirportsByZip(int zipcode);
	
	public Airport findAirportById(int airportId);
	
}
