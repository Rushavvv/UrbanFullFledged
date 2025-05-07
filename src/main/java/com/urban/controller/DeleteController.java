package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.urban.service.DashboardService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("role") == null) {
		    System.out.println("No Session");
		    response.sendRedirect("/login"); 
		    return;
		}
		
		String email = request.getParameter("email");
		DashboardService service = new DashboardService();
		boolean deleted = service.deleteUserByEmail(email); 


		String currentUserEmail = (String) session.getAttribute("userEmail");
		String emailToDelete = request.getParameter("email");

		if (emailToDelete.equals(currentUserEmail)) {
		    System.out.println("Don't delete yourself");
		    response.getWriter().println("You cannot delete yourself while logged in.");
		    return;
		}

		if (deleted) {
		    System.out.println("User Deleted");
		    response.sendRedirect("/dashboard"); 
		} else {
		    System.out.println("Failed to delete user.");
		    response.getWriter().println("Failed to delete user.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
