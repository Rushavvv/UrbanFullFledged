package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.urban.service.ControlService;

/**
 * Servlet implementation class ProductDeleteController
 */
@WebServlet("/productDelete")
public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String idParam = request.getParameter("id");
					
			if (idParam == null || idParam.isEmpty()) {
				response.getWriter().println("Product ID is required.");
				return;
			}
			
			try {
				int productId = Integer.parseInt(idParam);
				ControlService controlService = new ControlService();
				boolean deleted = controlService.deleteProductById(productId);
		
				if (deleted) {
					System.out.println("Product Deleted");
					response.sendRedirect("/adminControl");
				} else {
					System.out.println("Failed to delete product.");
					response.getWriter().println("Failed to delete product.");
				}
			} catch (NumberFormatException e) {
				response.getWriter().println("Invalid product ID.");
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
