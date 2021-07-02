package com.skillstorm.avionrapide.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.avionrapide.models.Reservation;
import com.skillstorm.avionrapide.services.ReservationService;

@WebServlet ("/pages/confirmreservation")
public class ConfirmReservationServlet extends HttpServlet {

	ReservationService rService = new ReservationService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation reservation = (Reservation)req.getSession().getAttribute("reservation");
		reservation.setReservationDate(LocalDate.now());
		int good = rService.saveReservation(reservation);
		if(good==999999999) {
			resp.sendRedirect("selectflights.jsp");
		}
		else {
		reservation.setConfirmationNumber(good);
		System.out.println(reservation.getConfirmationNumber());
		
		resp.sendRedirect("flightreservationbooked.jsp");
		}
	}
	
}
