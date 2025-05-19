package com.urban.controller;

import jakarta.servlet.ServletException;

import com.urban.model.UserModel;
import com.urban.service.DashboardService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.urban.util.RedirectionUtil;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/dashboard"})
public class AdminDashboardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

    public AdminDashboardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DashboardService dashboardService = new DashboardService();
		
		System.out.println("AdminDAhboard Controller called");
 	    int totalUsers = dashboardService.getTotalUsers();
		int totalRevenue = dashboardService.getTotalRevenue();
		int activeProducts = dashboardService.getActiveProducts();
		int outOfStock = dashboardService.getOutOfStockProducts();
		int profitMargin = dashboardService.getAverageOrderValue();
		int totalOrders = dashboardService.getTotalOrders();


		
		List<UserModel> recentUsers = dashboardService.getAllUserInfo();

		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("totalRevenue", totalRevenue);
		request.setAttribute("activeProducts", activeProducts);
		request.setAttribute("recentUsers", recentUsers);
		request.setAttribute("outOfStock", outOfStock);
		request.setAttribute("profitMargin", profitMargin);
		request.setAttribute("totalOrders", totalOrders);


		
		String action = request.getParameter("action");
	    String userEmail = request.getParameter("userEmail");

	    if ("Delete".equals(action) && userEmail != null && !userEmail.isEmpty()) {
	        boolean deleted = dashboardService.deleteUserByEmail(userEmail);
	        if (deleted) {
	            request.setAttribute("message", "User deleted successfully.");
	        } else {
	            request.setAttribute("error", "Failed to delete user.");
	        }
	    }

		request.getRequestDispatcher(RedirectionUtil.dashboardUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
