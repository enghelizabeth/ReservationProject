package com.skillstorm.avionrapide.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.avionrapide.models.Flight;

public class FlightDAOImpl implements FlightDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * find all flights regardless of any parameters
	 */
	public List<Flight> findAll() {
		final String FIND_ALL = "select * from flight";

		List<Flight> flights = new LinkedList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_ALL);
			while (rs.next()) {
				Flight object = new Flight(rs.getInt("flight_number"), rs.getObject("depart_date", LocalDate.class),
						rs.getTime("depart_time"), rs.getInt("origin_airport_id"), rs.getInt("destination_airport_id"),
						rs.getInt("seats_available"), rs.getBigDecimal("ticket_cost"));
				flights.add(object);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flights;
	}

	/**
	 * find all flights based on date, and both airports FIX THE DATE ON THIS
	 */
	public List<Flight> findAllFlights(int originAirportId, int destinationAirportId, LocalDate departDate) {
		final String FIND_ALL = "select * from flight where origin_airport_id=? and destination_airport_id=? and depart_date=?";
		List<Flight> flights = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_ALL);
			stmt.setInt(1, originAirportId);
			stmt.setInt(2, destinationAirportId);
			stmt.setDate(3, java.sql.Date.valueOf(departDate));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Flight object = new Flight(rs.getInt("flight_number"), rs.getObject("depart_date", LocalDate.class),
						rs.getTime("depart_time"), rs.getInt("origin_airport_id"), rs.getInt("destination_airport_id"),
						rs.getInt("seats_available"), rs.getBigDecimal("ticket_cost"));
				flights.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	public Flight findFlightByNumber(int flightNumber) {
		final String FIND_FLIGHT_BY_FLIGHT_NUMBER = "select * from flight where flight_number=?";
		Flight flight = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_FLIGHT_BY_FLIGHT_NUMBER);
			stmt.setInt(1, flightNumber);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			flight = new Flight(rs.getInt("flight_number"), rs.getObject("depart_date", LocalDate.class),
					rs.getTime("depart_time"), rs.getInt("origin_airport_id"), rs.getInt("destination_airport_id"),
					rs.getInt("seats_available"), rs.getBigDecimal("ticket_cost"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flight;
	}

	/**
	 * finds the number of seats available on the selected flight
	 */
	public int seatAvailable(int flightNumber) {
		final String FIND_SEATS_AVAILABLE = "select seats_available from flight where flight_number=?";
		int seatsAvail = 0;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_SEATS_AVAILABLE);
			stmt.setInt(1, flightNumber);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			seatsAvail = rs.getInt("seats_available");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return seatsAvail;
	}

	/**
	 * update the seats available on a flight
	 */
	public void updateSeats(int updatedSeatAvail, int flightNumber) {
		final String UPDATE_SEATS = "update flight set seats_available = ? where flight_number= ?";
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(UPDATE_SEATS);
			stmt.setInt(1, updatedSeatAvail);
			stmt.setInt(2, flightNumber);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
