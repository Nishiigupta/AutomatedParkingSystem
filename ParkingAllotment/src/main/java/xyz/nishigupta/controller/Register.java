package xyz.nishigupta.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.nishigupta.dao.RegisterDao;
import xyz.nishigupta.entities.RegistrationDetails;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final String email = request.getParameter("email");
		final String phone_number = request.getParameter("phone_number");
		final String buyerOrSeller = request.getParameter("buyer_seller");
		
		RegistrationDetails registerDetails = new RegistrationDetails(username, password, email, phone_number);
				
		final RegisterDao registerDao = new RegisterDao();
		
		if(!registerDetails.is_valid() || !registerDao.is_valid(registerDetails, buyerOrSeller)) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		final boolean is_saved = registerDao.save(registerDetails, buyerOrSeller);
		if(is_saved == false) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		response.sendRedirect("hello");
		
	}

}