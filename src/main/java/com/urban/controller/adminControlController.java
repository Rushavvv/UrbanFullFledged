package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.urban.model.ProductsModel;
import com.urban.model.UserModel;
import com.urban.service.ControlService;
import com.urban.service.DashboardService;
import com.urban.util.RedirectionUtil;

/**
 * Servlet implementation class adminControlController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/adminControl" })
public class adminControlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminControlController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ControlService controlService = new ControlService();
        List<ProductsModel> products = controlService.getAllProductDetails();

        String action = request.getParameter("action");
        String productIdParam = request.getParameter("productId");

        if ("Delete".equals(action) && productIdParam != null && !productIdParam.isEmpty()) {
            int productId = Integer.parseInt(productIdParam);
            boolean deleted = controlService.deleteProductById(productId);
            if (deleted) {
                request.setAttribute("message", "Product deleted successfully.");
            } else {
                request.setAttribute("error", "Failed to delete product.");
            }
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/pages/adminControl.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

	    if ("Add".equals(action)) {
	        try {
	            String name = request.getParameter("productName");
	            int price = Integer.parseInt(request.getParameter("productPrice"));
	            int quantity = Integer.parseInt(request.getParameter("inStock"));

	            ProductsModel product = new ProductsModel(name, price, quantity);
	            ControlService controlService = new ControlService();

	            boolean added = controlService.addProduct(product);

	            if (added) {
	                response.sendRedirect("adminControl");
	            } else {
	                request.setAttribute("error", "Failed to add product.");
	                request.getRequestDispatcher("WEB-INF/pages/addProduct.jsp").forward(request, response);
	            }
	        } catch (NumberFormatException e) {
	            request.setAttribute("error", "Invalid input for price or quantity.");
	            request.getRequestDispatcher("WEB-INF/pages/addProduct.jsp").forward(request, response);
	        }
	    } else {
	        doGet(request, response);
	    }
	}

}
