package com.urban.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.urban.model.UserModel;
import com.urban.service.RegisterService;
import com.urban.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/register"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
				 maxFileSize = 1024 * 1024 * 10,
				 maxRequestSize = 1024 * 1024 * 50)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			UserModel userModel = extractUserModel(req);
			Boolean isAdded = registerService.addUser(userModel);

			if (isAdded == null){
				handleError(req, resp, "Our server is under maintenance. Please try again later!");

			} else if(!isAdded){
				handleError(req, resp, "Could not register your account. Please try again later!");
			}else {
			//Upon successful registration
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			}
		} catch (Exception e) {
			handleError(req, resp, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}
	
	private UserModel extractUserModel(HttpServletRequest req) throws Exception {
		String number = req.getParameter("userNumber");
		String userName = req.getParameter("Name");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String role = req.getParameter("role");

		String password = req.getParameter("password");
		String retypePassword = req.getParameter("retypePassword");
		
		if (password == null || !password.equals(retypePassword)) {
			throw new Exception("Passwords do not match or are invalid.");
			
		}
		
		password = PasswordUtil.encrypt(userName, password);
		
		return new UserModel(number, userName, email, gender, role, password, dob);	
		} 
	
		
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String message)
			throws ServletException, IOException {
		req.setAttribute("error", message);
		req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
	}

}
