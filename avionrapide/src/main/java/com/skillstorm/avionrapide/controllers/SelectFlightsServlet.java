package com.skillstorm.avionrapide.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet takes the information from last page
 * Gets all available flights based on criteria
 * User selects the flights they would like to take on this page
 */
@WebServlet ("/pages/pleaseselectflights")
public class SelectFlightsServlet extends HttpServlet {
	
	/**
	 * this happens after selecting flights
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reservation reservation = new Reservation();
	}
	
	
}
