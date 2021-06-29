package com.skillstorm.avionrapide.data;

import java.util.List;

import com.skillstorm.avionrapide.models.Reservation;

public interface ReservationDAO {

	String url = "jdbc:mysql://localhost:3306/avionrapide";
	String username = "root";
	String password = "root";
	
	public int generateUniqueConfirmationNumber();
	
	public void saveReservation(Reservation reservation);
	
	public Reservation getReservationByConfirmNum(int confirmNum);
	
	public List<Reservation> getReservationsByPersonId(int personId);
	
	//public List<Reservation> getReservationsByEmail(String email);
	
	//public List<Reservation> getReservationsByPhoneNumber(String phoneNumber);
	
	public void deleteReservation(int confirm_num);
	
}
