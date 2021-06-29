package com.skillstorm.avionrapide.models;

import java.time.LocalDate;

public class TempModelForFlightDetails {

	public TempModelForFlightDetails() {
		super();
	}

	public TempModelForFlightDetails(int originAirportId, int destinationAirportId, LocalDate departDate,
			LocalDate returnDate) {
		super();
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.departDate = departDate;
		this.returnDate = returnDate;
	}

	private int originAirportId;
	private int destinationAirportId;
	private LocalDate departDate;
	private LocalDate returnDate;
	
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
	public LocalDate getDepartDate() {
		return departDate;
	}
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "TempModelForFlightDetails [originAirportId=" + originAirportId + ", destinationAirportId="
				+ destinationAirportId + ", departDate=" + departDate + ", returnDate=" + returnDate + "]";
	}
	
	
}
