package com.skillstorm.avionrapide.data;

public interface StateDAO {

	String url = "jdbc:mysql://localhost:3306/avionrapide";
	String username = "root";
	String password = "root";
	
	public String getStateAbbrev(String stateName);
	
}
