package com.DAO.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.avionrapide.data.PersonDAO;
import com.skillstorm.avionrapide.data.PersonDAOImpl;
import com.skillstorm.avionrapide.models.Person;

public class PersonTest {

	@Ignore
	@Test // WORKS
	public void testSavePerson() {
		PersonDAO dao = new PersonDAOImpl();
		try {
			dao.savePerson(new Person("Liz", "High", "7012402763", "enghelizabeth@yahoo.com", LocalDate.of(1995, 3, 28)));
			}catch(SQLIntegrityConstraintViolationException e) {
				assertFalse(true);
			}
		assertTrue(true);
	}

	// @Ignore //need to test
	/*@Test (expected = SQLException.class)
	public void testSavePersonException(){
		PersonDAO dao = new PersonDAOImpl();
			try {
			dao.savePerson(new Person("Liz", "High", "7012402763", "enghelizabeth@yahoo.com", LocalDate.of(1995, 3, 28)));
			System.out.println("Should have thrown an exception");
			System.out.println("Second print");
			}catch(SQLIntegrityConstraintViolationException e) {
				assertFalse(true);
			}
		assertTrue(true);
	}*/

	@Ignore
	@Test // WORKS
	public void testFindPersonByEmail() {
		PersonDAO dao = new PersonDAOImpl();
		Person result = dao.findPersonByEmail("enghelizabeth@yahoo.com");
		System.out.println(result);
		assertEquals(result.getFirstName(), "Liz");
		result = dao.findPersonByEmail("abeth@yahoo.com");
		System.out.println(result);
		assertNull(result);

	}

	@Ignore
	@Test // WORKS
	public void testFindPersonByPhone() {
		PersonDAO dao = new PersonDAOImpl();
		Person result = dao.findPersonByPhone("7012402763");
		System.out.println(result);
		assertEquals(result.getFirstName(), "Liz");
		result = dao.findPersonByPhone("70124027633");
		System.out.println(result);
		assertNull(result);
	}
	
	@Ignore
	@Test // WORKS
	public void testFindPersonById() {
		PersonDAO dao = new PersonDAOImpl();
		Person result = dao.findPersonById(50);
		System.out.println(result);
		assertEquals(result.getFirstName(), "Liz");
		result = dao.findPersonById(100);
		System.out.println(result);
		assertNull(result);
	}

	@Ignore
	@Test // WORKS
	public void testUpdatePerson() {
		PersonDAO dao = new PersonDAOImpl();
		dao.updatePerson(new Person(1, "Cody", "High", "4805321544", "cody@yahoo.com", LocalDate.of(1990, 5, 6)));
		Person check = dao.findPersonByEmail("cody@yahoo.com");
		assertEquals(check.getPersonId(), 1);
	}

	@Ignore
	@Test // do at a later time
	public void testDelete() {

	}

}
