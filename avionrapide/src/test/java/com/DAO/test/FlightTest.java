package com.DAO.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.avionrapide.data.FlightDAO;
import com.skillstorm.avionrapide.data.FlightDAOImpl;
import com.skillstorm.avionrapide.models.Flight;

public class FlightTest {

	
	@Ignore
	@Test 	//WORKS
	public void testFindAll() {
		FlightDAO dao = new FlightDAOImpl();
		List<Flight> result = dao.findAll();
		System.out.println(result);
		assertTrue(result.size()==50);
		assertNotNull(result);
	}
	
	@Ignore
	@Test 	//WORKS
	public void testFindAllFlights() {
		FlightDAO dao = new FlightDAOImpl();
		List<Flight> result = dao.findAllFlights(1, 7, LocalDate.of(2021, 8, 18));
		System.out.println(result);
		assertTrue(result.size()==1);
		assertNotNull(result);
		result = dao.findAllFlights(1, 1, LocalDate.of(2021, 8, 18));
		System.out.println(result);
		assertTrue(result.size()==0);
	}
	
	@Ignore
	@Test 	//works
	public void testSeatAvailable() {
		FlightDAO dao = new FlightDAOImpl();
		int result = dao.seatAvailable(24206676);
		System.out.println(result);
		assertTrue(result==84);
		result = dao.seatAvailable(1);
		System.out.println(result);
		assertTrue(result==0);
	}
	
	@Ignore
	@Test 	//WORKS
	public void testUpdateSeats() {
		FlightDAO dao = new FlightDAOImpl();
		dao.updateSeats(20, 410498266);
		int result = dao.seatAvailable(410498266);
		System.out.println(result);
		assertTrue(result==20);
	}
}
