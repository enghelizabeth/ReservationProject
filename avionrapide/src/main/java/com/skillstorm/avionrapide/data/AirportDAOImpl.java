package com.skillstorm.avionrapide.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.skillstorm.avionrapide.models.Airport;

public class AirportDAOImpl implements AirportDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { AirportDAO dao = new
	 * AirportDAOImpl(); System.out.println(dao.findAirport("Minot", "ND", 58703));
	 * }
	 */

	/**
	 * Finds all airports in the database, takes no user input
	 */
	public List<Airport> findAll() {
		final String FIND_ALL = "select * from airport";

		List<Airport> airports = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_ALL);
			while (rs.next()) {
				Airport object = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"),
						rs.getString("city"), rs.getString("state_abbrev"), rs.getInt("zipcode"));
				airports.add(object);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return airports;
	}

	/**
	 * Finds the airport by city, state, and zipcode: user can input the state name
	 * or abbrev, this works with either
	 */
	@Override
	public Airport findAirport(String city, String state, int zipcode) {
		final String FIND_AIRPORT = "select * from airport where city = ? and state_abbrev = ? and zipcode = ?";
		String stateAbbrev;
		Airport airport = null;
		if (state.length() == 2) {
			stateAbbrev = state;
		} else {
			StateDAO dao = new StateDAOImpl();
			// if abbrev == null, throw error<--------------NOT SURE HOW TO HANDLE THIS YET
			stateAbbrev = dao.getStateAbbrev(state);
		}

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT);
			stmt.setString(1, city);
			stmt.setString(2, stateAbbrev);
			stmt.setInt(3, zipcode);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			airport = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"), rs.getString("city"),
					rs.getString("state_abbrev"), rs.getInt("zipcode"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return airport;
	}

	/**
	 * User can just input the three digit airport code and this finds the airport
	 * associated with that code
	 */
	@Override
	public Airport findAirportByCode(String airportCode) {
		final String FIND_AIRPORT_BY_CODE = "select * from airport where airport_code = ?";
		Airport airport = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT_BY_CODE);
			stmt.setString(1, airportCode);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			airport = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"), rs.getString("city"),
					rs.getString("state_abbrev"), rs.getInt("zipcode"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airport;
	}

	/**
	 * If user inputs the state abbrev or fully spells out the name, this will find
	 * all airports in that state
	 */
	@Override
	public List<Airport> findAirportsByState(String state) {
		final String FIND_AIRPORT_BY_STATE = "select * from airport where state_abbrev = ?";
		String stateAbbrev;
		List<Airport> airports = new LinkedList<>();
		if (state.length() == 2) { // gets the state abbrev from state name
			stateAbbrev = state;
		} else {
			StateDAO dao = new StateDAOImpl();
			// if abbrev == null, throw error<--------------NOT SURE HOW TO HANDLE THIS YET
			stateAbbrev = dao.getStateAbbrev(state);
		}

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT_BY_STATE);
			stmt.setString(1, stateAbbrev);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Airport object = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"),
						rs.getString("city"), rs.getString("state_abbrev"), rs.getInt("zipcode"));
				airports.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airports;
	}

	/**
	 * Finds all airports in the city
	 */
	@Override
	public List<Airport> findAirportsByCity(String city) {
		final String FIND_AIRPORT_BY_CITY = "select * from airport where city = ?";
		List<Airport> airports = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT_BY_CITY);
			stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Airport object = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"),
						rs.getString("city"), rs.getString("state_abbrev"), rs.getInt("zipcode"));
				airports.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airports;
	}

	/**
	 * finds all airports by zipcode
	 */
	@Override
	public List<Airport> findAirportsByZip(int zipcode) {
		final String FIND_AIRPORT_BY_ZIP = "select * from airport where zipcode = ?";
		List<Airport> airports = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT_BY_ZIP);
			stmt.setInt(1, zipcode);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Airport object = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"),
						rs.getString("city"), rs.getString("state_abbrev"), rs.getInt("zipcode"));
				airports.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airports;
	}

	/**
	 * finds the airport by the airport_id(PK)
	 */
	@Override
	public Airport findAirportById(int airportId) {
		final String FIND_AIRPORT_BY_ID = "select * from airport where airport_id = ?";
		Airport airport = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_AIRPORT_BY_ID);
			stmt.setInt(1, airportId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			airport = new Airport(rs.getInt("airport_id"), rs.getString("airport_code"), rs.getString("city"),
					rs.getString("state_abbrev"), rs.getInt("zipcode"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airport;
	}

}
