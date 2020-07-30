package xyz.nishigupta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.nishigupta.dao.BookingDao;
import xyz.nishigupta.entities.BookingInfo;

@WebServlet("/bookparking")
public class BookParking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			String arrivalDate = request.getParameter("arrivalDate");
			String departureDate = request.getParameter("departureDate");
			String arrivalTime = request.getParameter("arrivalTime");
			String departureTime = request.getParameter("departureTime");
			String coordinates[] = request.getParameter("coordinates").split(",");
			final String parkingName = request.getParameter("parkingName");
			final String coordX = coordinates[0];
			final String coordY = coordinates[1];
			
			final BookingInfo bookingInfo = new BookingInfo(coordX, coordY, parkingName);
			bookingInfo.setArrivalDate(arrivalDate);
			bookingInfo.setArrivalTime(arrivalTime);
			bookingInfo.setDepartureTime(departureTime);
			bookingInfo.setDepartureDate(departureDate);
			
			if(!bookingInfo.isValid()) {
				System.out.println("Validation Failed");
				response.sendRedirect("index.jsp");
				return;
			}
			
			BookingDao bookingDao = new BookingDao(bookingInfo);
			bookingDao.validate();
			System.out.println(bookingInfo.isAvailable());
			System.out.println(bookingInfo.getAvailability());
			HttpSession session = request.getSession();
			session.setAttribute("bookingInfo", bookingInfo);
			
			RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			System.out.println("Exception ");
			response.sendRedirect("index.jsp");
		}
		
	}

}
