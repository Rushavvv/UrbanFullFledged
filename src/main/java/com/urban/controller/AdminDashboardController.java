package com.urban.controller;

import jakarta.servlet.ServletException;
import com.urban.service.DashboardService;
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
public class AdminDashboardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Instance of DashboardService for handling business logic
    private DashboardService dashboardService;

    public AdminDashboardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DashboardService dashboardService = new DashboardService();
//
//	    int totalUsers = dashboardService.getTotalUsers();
//	    double totalRevenue = dashboardService.getTotalRevenue();
//	    int activeProducts = dashboardService.getActiveProducts();
//
//	    request.setAttribute("totalUsers", totalUsers);
//	    request.setAttribute("totalRevenue", totalRevenue);
//	    request.setAttribute("activeProducts", activeProducts);
		request.getRequestDispatcher(RedirectionUtil.dashboardUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
