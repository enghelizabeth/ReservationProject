package com.skillstorm.avionrapide.services;

import javax.swing.JOptionPane;

import com.skillstorm.avionrapide.data.FlightDAO;
import com.skillstorm.avionrapide.data.FlightDAOImpl;
import com.skillstorm.avionrapide.data.ReservationDAO;
import com.skillstorm.avionrapide.data.ReservationDAOImpl;
import com.skillstorm.avionrapide.models.Reservation;

public class ReservationService {

	public int saveReservation(Reservation reservation) {
		ReservationDAO dao = new ReservationDAOImpl();
		FlightDAO fDAO = new FlightDAOImpl();
		int seatsUpdatedDeparting = fDAO.seatAvailable(reservation.getDepartingFlightNumber()) - reservation.getNumSeatsBooked();
		int seatsUpdatedReturning = fDAO.seatAvailable(reservation.getReturningFlightNumber()) - reservation.getNumSeatsBooked();
				
		if(seatsUpdatedDeparting > 0 && seatsUpdatedReturning > 0) {
			dao.saveReservation(reservation);
			fDAO.updateSeats(seatsUpdatedDeparting, reservation.getDepartingFlightNumber());
			fDAO.updateSeats(seatsUpdatedReturning, reservation.getReturningFlightNumber());
			return dao.getConfirmationNumber(reservation.getPersonId(), reservation.getDepartingFlightNumber(),
					reservation.getReturningFlightNumber());
		}
		else {
			
			return 999999999;
		}
		
		
	
	}
	
	
}
