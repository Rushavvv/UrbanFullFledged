package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.urban.service.DashboardService;
import com.urban.util.ImageUtil;
import com.urban.util.PasswordUtil;
import com.urban.util.ValidationUtil;

/**
 * Servlet implementation class EditProfileController
 */
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
	    maxFileSize = 1024 * 1024 * 10,       // 10MB
	    maxRequestSize = 1024 * 1024 * 15     // 15MB
	)
@WebServlet(asyncSupported = true, urlPatterns = {"/editProfile"})
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ImageUtil imageUtil = new ImageUtil();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/pages/editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	    	req.setCharacterEncoding("UTF-8");

	        // Extract form parameters
	        String userName = (String) req.getSession().getAttribute("userName");
	        String fullName = req.getParameter("userName");
	        String email = req.getParameter("userEmail");
	        String phone = req.getParameter("userNumber");
	        String password = req.getParameter("password");

	        // Validate fields
	        if (ValidationUtil.isEmpty(fullName) || !ValidationUtil.isNameValid(fullName)) {
	            handleError(req, resp, "Invalid name. Only letters and spaces allowed.");
	            return;
	        }

	        if (ValidationUtil.isEmpty(email) || !ValidationUtil.isEmailValid(email)) {
	            handleError(req, resp, "Invalid email format.");
	            return;
	        }

	        if (ValidationUtil.isEmpty(password) || !ValidationUtil.isPasswordStrong(password)) {
	            handleError(req, resp, "Password must be at least 6 characters.");
	            return;
	        }


	        if (!ValidationUtil.isPhoneValid(phone)) {
	            handleError(req, resp, "Invalid phone number.");
	            return;
	        }

	        // Encrypt password
	        String encryptedPassword = PasswordUtil.encrypt(userName, password);

	        // Handle image upload
	        Part image = req.getPart("image");
	        String imageUrl = imageUtil.getImageNameFromPart(image);
	        boolean isUploaded = imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "user");
	        if (!isUploaded) {
	            handleError(req, resp, "Failed to upload profile image. Try again.");
	            return;
	        }

	        // Update in DB
	        DashboardService dashboardService = new DashboardService();

	        boolean isUpdated = dashboardService.updateUserProfile(userName, email, phone, encryptedPassword, imageUrl);

	        if (isUpdated) {
	            req.getSession().setAttribute("success", "Profile updated successfully.");
	            resp.sendRedirect(req.getContextPath() + "/profile");
	        } else {
	            handleError(req, resp, "Failed to update profile. Try again.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        handleError(req, resp, "Unexpected error occurred.");
	    }
	}

	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
	    req.setAttribute("errorMessage", message);
	    req.getRequestDispatcher("WEB-INF/pages/editProfile.jsp").forward(req, resp);
	}

}
