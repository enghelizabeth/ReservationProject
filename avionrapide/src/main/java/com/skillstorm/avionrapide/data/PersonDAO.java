package com.skillstorm.avionrapide.data;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

import com.skillstorm.avionrapide.models.Person;

public interface PersonDAO {

	String url = "jdbc:mysql://localhost:3306/avionrapide";
	String username = "root";
	String password = "root";
		
	public void savePerson(Person person) throws SQLIntegrityConstraintViolationException;
	
	public Person findPersonByEmail(String email);
	
	public Person findPersonByPhone(String phone);
	
	public Person findPersonById(int personId);
	
	public void updatePerson(Person person);
	
	public void delete(int personId);
}
