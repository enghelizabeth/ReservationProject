package com.skillstorm.avionrapide.data;

import java.time.LocalDate;
import java.util.List;

import com.skillstorm.avionrapide.models.Flight;

public interface FlightDAO {

	String url = "jdbc:mysql://localhost:3306/avionrapide";
	String username = "root";
	String password = "root";
	
	public List<Flight> findAll();
	
	public List<Flight> findAllFlights(int originAirportId, int destinationAirportId, LocalDate departDate);
	
	public int seatAvailable(int flightNumber);
	
	public void updateSeats(int updatedSeatsAvail, int flightNumber);
	
}
