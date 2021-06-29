package com.skillstorm.avionrapide.models;

public class State {

	public State() {
		super();
	}
	
	public State(String state_name, String state_abbrev) {
		super();
		this.state_name = state_name;
		this.state_abbrev = state_abbrev;
	}
	
	private String state_name;
	private String state_abbrev;
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getState_abbrev() {
		return state_abbrev;
	}
	public void setState_abbrev(String state_abbrev) {
		this.state_abbrev = state_abbrev;
	}
}
