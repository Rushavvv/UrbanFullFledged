package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.urban.util.RedirectionUtil;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/dashboard"})
public class AdminDashboard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AdminDashboard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print('0');
		request.getRequestDispatcher(RedirectionUtil.dashboardUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
