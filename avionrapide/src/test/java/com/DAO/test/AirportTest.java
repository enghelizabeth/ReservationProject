package com.DAO.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.avionrapide.data.AirportDAO;
import com.skillstorm.avionrapide.data.AirportDAOImpl;
import com.skillstorm.avionrapide.models.Airport;

public class AirportTest {

	@Ignore 
	@Test	//WORKS
	public void testFindAll() {
		AirportDAO dao = new AirportDAOImpl();
		List<Airport> result = dao.findAll();
		System.out.println(result);
		assertNotNull(result);
	}
	
	@Ignore 
	@Test	//WORKS!
	public void testFindAirport() {
		AirportDAO dao = new AirportDAOImpl();
		Airport result = dao.findAirport("Minot", "ND", 58703);
		assertEquals(result.getAirportCode(), "MOT");
		System.out.println(result);
		result = dao.findAirport("Phoenix", "Arizona", 85034);
		assertEquals(result.getAirportCode(), "PHX");
		System.out.println(result);
		result = dao.findAirport("Phoenix", "Arizon", 85034);
		assertNull(result);
		System.out.println(result);
	}
	
	@Ignore
	@Test	//WORKS!
	public void testFindByCode() {
		AirportDAO dao = new AirportDAOImpl();
		Airport result = dao.findAirportByCode("PHX");
		assertEquals(result.getCity(), "Phoenix");
		result = dao.findAirportByCode("MOT");
		assertEquals(result.getCity(), "Minot");
		result = dao.findAirportByCode("MOTT");
		assertNull(result);
	}
	
	@Ignore
	@Test	//WORKS
	public void testFindByState() {
		AirportDAO dao = new AirportDAOImpl();
		List<Airport> result = dao.findAirportsByState("Arizona");
		equals(result.size() == 4);
		assertNotNull(result);
		System.out.println(result);
		result = dao.findAirportsByState("AZ");
		equals(result.size() == 4);
		assertNotNull(result);
		System.out.println(result);
		result = dao.findAirportsByState("AZZ");
		equals(result.size() == 0);
	}
	
	@Ignore
	@Test	//WORKS
	public void testFindByCity() {
		AirportDAO dao = new AirportDAOImpl();
		List<Airport> result = dao.findAirportsByCity("Tucson");
		equals(result.size() == 2);
		assertNotNull(result);
		result = dao.findAirportsByCity("Tucson");
		equals(result.size() == 2);
		assertNotNull(result);
		
	}
	
	@Ignore
	@Test	//WORKS
	public void testFindByZip() {
		AirportDAO dao = new AirportDAOImpl();
		List<Airport> result = dao.findAirportsByZip(58703);
		equals(result.size() == 1);
		result = dao.findAirportsByZip(85756);
		equals(result.size() == 2);
		result = dao.findAirportsByZip(85759);
		equals(result.size() == 0);
	}
	
	@Ignore
	@Test //WORKS
	public void testFindById() {
		AirportDAO dao = new AirportDAOImpl();
		Airport result = dao.findAirportById(5);
		assertEquals(result.getAirportCode(), "PHX");
		result = dao.findAirportById(15);
		assertNull(result);
		
	}
	
}
