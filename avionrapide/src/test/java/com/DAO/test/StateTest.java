package com.DAO.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.avionrapide.data.StateDAO;
import com.skillstorm.avionrapide.data.StateDAOImpl;

public class StateTest{
	
	@Ignore //works!
	@Test
	public void testGetStateAbbrev() {
		StateDAO dao = new StateDAOImpl();
		String result = dao.getStateAbbrev("Arizona");
		assertEquals(result, "AZ");
		assertNotEquals(result, "ND");
	}
	
}