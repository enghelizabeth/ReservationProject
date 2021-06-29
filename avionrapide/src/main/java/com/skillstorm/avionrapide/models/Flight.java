package com.skillstorm.avionrapide.models;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class Flight {

	public Flight() {
		super();
	}

	public Flight(int flightNumber, LocalDate departDate, Time departTime, int originAirportId, 
			int destinationAirportId, int seatsAvailable, BigDecimal ticketCost) {
		super();
		this.flightNumber = flightNumber;
		this.departDate = departDate;
		this.departTime = departTime;
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.seatsAvailable = seatsAvailable;
		this.ticketCost = ticketCost;
	}



	private int flightNumber;
	private LocalDate departDate;
	private Time departTime;
	private int originAirportId;
	private int destinationAirportId;
	private int seatsAvailable;
	private BigDecimal ticketCost;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	public Time getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}

	public int getOriginAirportId() {
		return originAirportId;
	}

	public void setOriginAirportId(int originAirportId) {
		this.originAirportId = originAirportId;
	}

	public int getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(int destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public BigDecimal getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(BigDecimal ticketCost) {
		this.ticketCost = ticketCost;
	}



	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", departDate=" + departDate + ", departTime=" + departTime
				+ ", originAirportId=" + originAirportId + ", destinationAirportId=" + destinationAirportId
				+ ", seatsAvailable=" + seatsAvailable + ", ticketCost=" + ticketCost + "]";
	}

}
