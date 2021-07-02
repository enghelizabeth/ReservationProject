package com.skillstorm.avionrapide.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.avionrapide.models.Person;
import com.skillstorm.avionrapide.models.Reservation;
import com.skillstorm.avionrapide.services.CustomerService;

@WebServlet({ "/pages/customerdetails" })
public class CustomerDetailsServlet extends HttpServlet {

	CustomerService cService = new CustomerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reservation reservation = (Reservation) req.getSession().getAttribute("reservation");
		Person person = new Person(req.getParameter("firstName"), req.getParameter("lastName"),
				req.getParameter("phone"), req.getParameter("email"), LocalDate.parse(req.getParameter("birthdate")));
		System.out.println(person.getEmail());
		Person tempperson = cService.getPerson(person);
		reservation.setPersonId(tempperson.getPersonId());

		req.getSession().setAttribute("reservation", reservation);
		req.getSession().setAttribute("person", tempperson);
		resp.sendRedirect("confirmreservation.jsp");
	}

}
