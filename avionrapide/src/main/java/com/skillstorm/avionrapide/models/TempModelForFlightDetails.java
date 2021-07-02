package com.skillstorm.avionrapide.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TempModelForFlightDetails {

	public TempModelForFlightDetails() {
		super();
		
	}



	private int originAirportId;
	private String originAirportCode;
	private int destinationAirportId;
	private String destinationAirportCode;
	private LocalDate departDate;
	private LocalDate returnDate;
	private int numOfTravelers;
	private BigDecimal totalCost;
	private BigDecimal taxCost;
	
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
	public int getNumOfTravelers() {
		return numOfTravelers;
	}

	public void setNumOfTravelers(int numOfTravelers) {
		this.numOfTravelers = numOfTravelers;
	}
	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}
	

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = new BigDecimal(0);
		this.totalCost = this.totalCost.add(totalCost);
	}
	public BigDecimal getTaxCost() {
		return taxCost;
	}
	public void setTaxCost(BigDecimal taxCost) {
		this.taxCost = new BigDecimal(0);
		this.taxCost = this.taxCost.add(taxCost);
	}
	@Override
	public String toString() {
		return "TempModelForFlightDetails [originAirportId=" + originAirportId + ", originAirportCode="
				+ originAirportCode + ", destinationAirportId=" + destinationAirportId + ", destinationAirportCode="
				+ destinationAirportCode + ", departDate=" + departDate + ", returnDate=" + returnDate
				+ ", numOfTravelers=" + numOfTravelers + ", totalCost=" + totalCost + "]";
	}

	
}
