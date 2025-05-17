package com.urban.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.urban.model.UserModel;
import com.urban.service.RegisterService;
import com.urban.util.ImageUtil;
import com.urban.util.PasswordUtil;
import com.urban.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
				 maxFileSize = 1024 * 1024 * 10,
				 maxRequestSize = 1024 * 1024 * 50)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ImageUtil imageUtil = new ImageUtil();
	private final RegisterService registerService = new RegisterService();


    public RegisterController() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req, resp);
	}

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Extract and validate parameters
            String number = req.getParameter("userNumber");
            String userName = req.getParameter("Name");
            String dobStr = req.getParameter("dob");
            String gender = req.getParameter("gender");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String retypePassword = req.getParameter("retypePassword");

            // Validation
            if (ValidationUtil.isEmpty(userName) || !ValidationUtil.isNameValid(userName)) {
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

            if (!password.equals(retypePassword)) {
                handleError(req, resp, "Passwords do not match.");
                return;
            }

            if (!ValidationUtil.isPhoneValid(number)) {
                handleError(req, resp, "Invalid phone number.");
                return;
            }

            if (ValidationUtil.isEmpty(dobStr)) {
                handleError(req, resp, "Date of birth is required.");
                return;
            }

            if (ValidationUtil.isEmpty(gender)) {
                handleError(req, resp, "Please select a gender.");
                return;
            }

            LocalDate dob = LocalDate.parse(dobStr);

            // Encrypt password
            String encryptedPassword = PasswordUtil.encrypt(userName, password);

            // Upload image
            Part image = req.getPart("image");
            String imageUrl = imageUtil.getImageNameFromPart(image);
            boolean isUploaded = imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "user");
            if (!isUploaded) {
                handleError(req, resp, "Failed to upload profile image. Try again.");
                return;
            }

            // Prepare user model
            UserModel userModel = new UserModel(
                    number, userName, email, gender, "user",
                    encryptedPassword, dob, imageUrl
            );

            // Save user
            Boolean isAdded = registerService.addUser(userModel);
            if (isAdded == null) {
                handleError(req, resp, "Server is under maintenance. Try again later.");
            } else if (!isAdded) {
                handleError(req, resp, "Could not register your account. Try again later.");
            } else {
                req.getSession().setAttribute("success", "Registration successful. You can now log in!");
                resp.sendRedirect(req.getContextPath() + "/login");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log error
            handleError(req, resp, "An unexpected error occurred. Please try again.");
        }
    }
	
	
	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("image");
		System.out.println(image);
		return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "user");
	}
	
		
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
	}
	
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

}
