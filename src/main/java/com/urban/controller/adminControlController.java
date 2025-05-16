package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
public class AdminControlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControlController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ControlService controlService = new ControlService();

        String searchQuery = request.getParameter("Search");
        List<ProductsModel> searchProducts;

        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            ProductsModel found = controlService.binarySearchProductByName(searchQuery.trim());
            searchProducts = new ArrayList<>();
            if (found != null) {
                searchProducts.add(found);
            }
            request.setAttribute("searchQuery", searchQuery); 
        } else {
            searchProducts = controlService.getAllProductDetails();
        }

                request.setAttribute("products", searchProducts);

        request.getRequestDispatcher("WEB-INF/pages/adminControl.jsp").forward(request, response);

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
	    ControlService controlService = new ControlService();
        String productId = request.getParameter("productId");


	    if ("Add".equals(action)) {
	        String name = request.getParameter("productName");
	        int price = Integer.parseInt(request.getParameter("productPrice"));
	        int quantity = Integer.parseInt(request.getParameter("inStock"));

	        ProductsModel product = new ProductsModel(name, price, quantity); 
	        boolean added = controlService.addProduct(product);

	        if (added) {
	            response.sendRedirect("adminControl");
	        } else {
	            request.setAttribute("error", "Failed to add product.");
	            request.getRequestDispatcher("WEB-INF/pages/adminControl.jsp").forward(request, response);
	        }

	    } else if ("Delete".equals(action) && productId != null && !productId.isEmpty()) {
            int prodId = Integer.parseInt(productId);
            boolean deleted = controlService.deleteProductById(prodId);
            if (deleted) {
	            response.sendRedirect("adminControl");
                request.setAttribute("message", "Product deleted successfully.");
                return;
                
            } else {
                request.setAttribute("error", "Failed to delete product.");
            }
            
        } else if ("Edit".equals(action)) {
	        int id = Integer.parseInt(request.getParameter("productId"));
	        String name = request.getParameter("productName");
	        int price = Integer.parseInt(request.getParameter("productPrice"));
	        int quantity = Integer.parseInt(request.getParameter("inStock"));

	        ProductsModel product = new ProductsModel(id, name, price, quantity);  
	        boolean updated = controlService.updateProduct(product);

	        if (updated) {
	            response.sendRedirect("adminControl");
	        } else {
	            request.setAttribute("error", "Failed to update product.");
	            request.getRequestDispatcher("WEB-INF/pages/adminControl.jsp").forward(request, response);
	        }
	    }
	}

}
