package com.skillstorm.avionrapide.services;

import com.skillstorm.avionrapide.data.PersonDAO;
import com.skillstorm.avionrapide.data.PersonDAOImpl;
import com.skillstorm.avionrapide.models.Person;

public class CustomerService {

	PersonDAO personDAO = new PersonDAOImpl();

	// check if the person returned is the same as the DB
	// create a new person if not, update
	public Person getPerson(Person person) {

		System.out.println("in cust service");

		String sanitizedPhone = person.getPhone().replaceAll("[\\D]", "");
		System.out.println(person.getPhone());
		System.out.println(sanitizedPhone);
		person.setPhone(sanitizedPhone);
		Person tempPerson = personDAO.findPersonByEmail(person.getEmail());
		if (tempPerson == null) {
			try {
				personDAO.savePerson(person);
				tempPerson = personDAO.findPersonByEmail(person.getEmail());
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		System.out.println(tempPerson.getFirstName());
		System.out.println(tempPerson.getPersonId());
		
		return tempPerson;
	}
}
