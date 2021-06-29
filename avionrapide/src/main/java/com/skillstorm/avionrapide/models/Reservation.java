package com.skillstorm.avionrapide.models;

import java.time.LocalDate;


public class Reservation {

	public Reservation() {
		super();
	}

	public Reservation(int numSeatsBooked, int personId, int departingFlightNumber,
			int returningFlightNumber, LocalDate date) {
		super();
		this.numSeatsBooked = numSeatsBooked;
		this.personId = personId;
		this.departingFlightNumber = departingFlightNumber;
		this.returningFlightNumber = returningFlightNumber;
		this.reservationDate = date;
	}
	
	public Reservation(int confirmationNumber, int numSeatsBooked, int personId, int departingFlightNumber,
			int returningFlightNumber, LocalDate date) {
		super();
		this.confirmationNumber = confirmationNumber;
		this.numSeatsBooked = numSeatsBooked;
		this.personId = personId;
		this.departingFlightNumber = departingFlightNumber;
		this.returningFlightNumber = returningFlightNumber;
		this.reservationDate = date;
	}

	private int confirmationNumber;
	private int numSeatsBooked;
	private int personId;
	private int departingFlightNumber;
	private int returningFlightNumber;
	private LocalDate reservationDate;

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public int getNumSeatsBooked() {
		return numSeatsBooked;
	}

	public void setNumSeatsBooked(int numSeatsBooked) {
		this.numSeatsBooked = numSeatsBooked;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getDepartingFlightNumber() {
		return departingFlightNumber;
	}

	public void setDepartingFlightNumber(int departingFlightNumber) {
		this.departingFlightNumber = departingFlightNumber;
	}

	public int getReturningFlightNumber() {
		return returningFlightNumber;
	}

	public void setReturningFlightNumber(int returningFlightNumber) {
		this.returningFlightNumber = returningFlightNumber;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return "Reservation [confirmationNumber=" + confirmationNumber + ", numSeatsBooked=" + numSeatsBooked
				+ ", personId=" + personId + ", departingFlightNumber=" + departingFlightNumber
				+ ", returningFlightNumber=" + returningFlightNumber + ", reservationDate=" + reservationDate + "]";
	}
}
