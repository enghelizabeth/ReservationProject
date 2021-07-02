package com.skillstorm.avionrapide.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.skillstorm.avionrapide.models.Person;

public class PersonDAOImpl implements PersonDAO{

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * FIX EXCEPTION HANDLING HERE
	 * Otherwise, this works like a charm. 
	 */
	public void savePerson(Person person) throws SQLIntegrityConstraintViolationException{
		final String INSERT_PERSON = "insert into person(first_name, last_name, email, phone, birthdate) values (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(INSERT_PERSON);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getEmail());
			stmt.setString(4, person.getPhone());
			stmt.setDate(5, java.sql.Date.valueOf(person.getBirthdate()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			if (e.getSQLState().startsWith("23")) {
                JOptionPane.showMessageDialog(null, "Duplicate");
          }
			e.printStackTrace();	
		}
	}
	
	/**
	 * enter an email and get a person object back
	 */
	public Person findPersonByEmail(String email) {
		final String FIND_BY_EMAIL = "select * from person where email = ?";
		Person person = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_BY_EMAIL);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			person = new Person(rs.getInt("person_id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("phone"), rs.getString("email"), rs.getObject("birthdate", LocalDate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	/**
	 * pass in a phone number and find a person
	 */
	public Person findPersonByPhone(String phone) {
		final String FIND_BY_PHONE = "select * from person where phone = ?";
		Person person = null;
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_BY_PHONE);
			stmt.setString(1, phone);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			person = new Person(rs.getInt("person_id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("phone"), rs.getString("email"), rs.getObject("birthdate", LocalDate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	/**
	 * enter an id number and receive the person associated with it
	 */
	public Person findPersonById(int personId) {
		final String FIND_BY_ID = "select * from person where person_id = ?";
		Person person = null;
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, personId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			person = new Person(rs.getInt("person_id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("phone"), rs.getString("email"), rs.getObject("birthdate", LocalDate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	/**
	 * 
	 */
	public void updatePerson(Person person) {
		final String UPDATE_PERSON = "update person set first_name = ?, last_name = ?, phone = ?, email = ?, birthdate = ? where person_id = ?";
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE_PERSON);
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setString(3, person.getPhone());
			stmt.setString(4, person.getEmail());
			stmt.setDate(5, java.sql.Date.valueOf(person.getBirthdate()));
			stmt.setInt(6, person.getPersonId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * will look at this later, not a top priority
	 */
	public void delete(int personId) {
		throw new UnsupportedOperationException("Still working on it");
		
		
		
	}

}
