package com.DAO.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.avionrapide.data.ReservationDAO;
import com.skillstorm.avionrapide.data.ReservationDAOImpl;
import com.skillstorm.avionrapide.models.Reservation;


public class ReservationTest {

	
	@Ignore
	@Test 	//WORKS
	public void testSaveReservation() {
		ReservationDAO dao = new ReservationDAOImpl();
		dao.saveReservation(new Reservation(2, 5, 355146493, 57864642, LocalDate.of(2021, 06, 28)));
		//check DB
	}
	
	@Ignore
	@Test 	//WORKS
	public void testGetReservationByConfirmNum() {
		ReservationDAO dao = new ReservationDAOImpl();
		Reservation result = dao.getReservationByConfirmNum(50);
		System.out.println(result);
		assertEquals(result.getPersonId(), 18);
		result = dao.getReservationByConfirmNum(100);
		System.out.println(result);
		assertNull(result);
	}
	
	@Ignore
	@Test 	//WORKS
	public void testGetReservationsByPersonId() {
		ReservationDAO dao = new ReservationDAOImpl();
		List<Reservation> result = dao.getReservationsByPersonId(12);
		System.out.println(result);
		assertTrue(result.size()==4);
		assertNotNull(result);
		result = dao.getReservationsByPersonId(120);
		System.out.println(result);
		assertEquals(result.size(), 0);
	}
	
	@Ignore
	@Test 	//need to test - haven't written this method, not important at this point
	public void testDeleteReservation() {
		ReservationDAO dao = new ReservationDAOImpl();
		dao.deleteReservation(10);
		assertNull(dao.getReservationByConfirmNum(10));
	}
	
}