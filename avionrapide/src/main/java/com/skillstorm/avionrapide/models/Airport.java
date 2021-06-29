package com.skillstorm.avionrapide.models;

public class Airport {

	public Airport() {
		super();
	}
	
	

	public Airport(int airportId, String airportCode, String city, String stateAbbrev, int zipcode) {
		super();
		this.airportId = airportId;
		this.airportCode = airportCode;
		this.city = city;
		this.stateAbbrev = stateAbbrev;
		this.zipcode = zipcode;
	}



	private int airportId;
	private String airportCode;
	private String city;
	private String stateAbbrev;
	private int zipcode;
	public int getAirportId() {
		return airportId;
	}



	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}



	public String getAirportCode() {
		return airportCode;
	}



	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getStateAbbrev() {
		return stateAbbrev;
	}



	public void setStateAbbrev(String stateAbbrev) {
		this.stateAbbrev = stateAbbrev;
	}



	public int getZipcode() {
		return zipcode;
	}



	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}



	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportCode=" + airportCode + ", city=" + city + ", stateAbbrev="
				+ stateAbbrev + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
