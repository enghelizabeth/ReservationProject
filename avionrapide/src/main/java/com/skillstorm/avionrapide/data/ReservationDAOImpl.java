package com.skillstorm.avionrapide.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.avionrapide.models.Reservation;

public class ReservationDAOImpl implements ReservationDAO {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * work on this last, make a long confirm num
	 */
	public int generateUniqueConfirmationNumber() {
		return 0;
	}

	/**
	 * save a reservation, no confirmation number needed, autocreated by the DB
	 */
	public void saveReservation(Reservation reservation) {
		final String INSERT = "insert into reservation(num_seats_booked, person_id, departing_flight_number, returning_flight_number, reservation_date) values (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(INSERT);
			stmt.setInt(1, reservation.getNumSeatsBooked());
			stmt.setInt(2, reservation.getPersonId());
			stmt.setInt(3, reservation.getDepartingFlightNumber());
			stmt.setInt(4, reservation.getReturningFlightNumber());
			stmt.setDate(5, java.sql.Date.valueOf(reservation.getReservationDate()));
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * the user can enter their confirmation number to find their flight details
	 */
	public Reservation getReservationByConfirmNum(int confirmNum) {
		final String FIND_RES_BY_CONFIRM_NUM = "select * from reservation where confirmation_number=?";
		Reservation reservation = null;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_RES_BY_CONFIRM_NUM);
			stmt.setInt(1, confirmNum);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			reservation = new Reservation(rs.getInt("confirmation_number"), rs.getInt("num_seats_booked"),
					rs.getInt("person_id"), rs.getInt("departing_flight_number"), rs.getInt("returning_flight_number"),
					rs.getObject("reservation_date", LocalDate.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

	/**
	 * get a list of all reservations by a persons id, this will 
	 */
	public List<Reservation> getReservationsByPersonId(int personId) {
		final String FIND_RES_BY_PERSON_ID = "select * from reservation where person_id=?";
		List<Reservation> reservations = new LinkedList<>();

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_RES_BY_PERSON_ID);
			stmt.setInt(1, personId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Reservation object = new Reservation(rs.getInt("confirmation_number"), rs.getInt("num_seats_booked"),
						rs.getInt("person_id"), rs.getInt("departing_flight_number"),
						rs.getInt("returning_flight_number"), rs.getObject("reservation_date", LocalDate.class));
				reservations.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;

	}
	
	public int getConfirmationNumber(int personId, int departFlightNumber, int returnFlightNumber) {
		final String FIND_RES_BY_CONFIRM_NUM = "select confirmation_number from reservation where person_id=? and departing_flight_number=? and returning_flight_number=?";
		int confirmationNumber = 0;

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_RES_BY_CONFIRM_NUM);
			stmt.setInt(1, personId);
			stmt.setInt(2, departFlightNumber);
			stmt.setInt(3, returnFlightNumber);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			confirmationNumber = rs.getInt("confirmation_number");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmationNumber;
		
	}

	/**
	 * come back and work on this at a later date
	 */
	public void deleteReservation(int confirm_num) {
		throw new UnsupportedOperationException("Still working on it");
	}

}
