package xyz.nishigupta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.nishigupta.dao.LoginDao;


@WebServlet("/login")
public class Login extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Login");
		String buyer_seller = request.getParameter("buyer_seller");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		boolean is_valid = dao.valid(username, password, buyer_seller);
		System.out.println(is_valid);
		if(is_valid) {
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect("index.jsp");
			return;
		}
		
		response.sendRedirect("login.jsp");
		
	}

}