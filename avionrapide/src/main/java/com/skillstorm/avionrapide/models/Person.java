package com.skillstorm.avionrapide.models;

import java.time.LocalDate;
import java.util.Date;

public class Person {

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, String phone, String email, LocalDate birthdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public Person(int personId, String firstName, String lastName, String phone, String email, LocalDate birthdate) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
	}

	private int personId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private LocalDate birthdate;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
}
