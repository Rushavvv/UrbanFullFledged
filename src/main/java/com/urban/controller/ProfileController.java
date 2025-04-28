package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.urban.model.UserModel;
import com.urban.service.LoginService;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
    	String username = (String) request.getSession().getAttribute("userName"); // Get from session

        if (username != null) {
            LoginService loginService = new LoginService();
            UserModel user = loginService.getUserDetails(username);
			if (user != null) {
			    request.setAttribute("user", user); // Passing user data to JSP
			    System.out.println("User fetched: " + user.getUserName());
			} else {
			    request.setAttribute("error", "User not found!");
			}
        } else {
            request.setAttribute("error", "No user logged in!");
        }
        
        request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
