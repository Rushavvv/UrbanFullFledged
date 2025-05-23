package com.urban.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.urban.model.UserModel;
import com.urban.service.LoginService;
import com.urban.util.CookiesUtil;
import com.urban.util.RedirectionUtil;
import com.urban.util.SessionUtil;
import com.urban.util.ValidationUtil;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/login", "/"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidationUtil validationUtil;
	private RedirectionUtil redirectionUtil;
	private LoginService loginService;
	
	@Override
	public void init() throws ServletException {
		this.validationUtil = new ValidationUtil();
		this.redirectionUtil = new RedirectionUtil();
		this.loginService = new LoginService();
	}
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		String password = req.getParameter("password");
		String userrole = loginService.getUserRole(username);
		

		if (!validationUtil.isEmpty(username) && !validationUtil.isEmpty(password)) {

			UserModel userModel = new UserModel(username, password);
			Boolean loginStatus = loginService.loginUser(userModel);


			if (loginStatus != null && loginStatus) {
				SessionUtil.setAttribute(req, "userName", username);
				
				UserModel emailUserModel = loginService.getUserDetails(username);
				SessionUtil.setAttribute(req, "userEmail", emailUserModel.getUserEmail());
				
				if ("admin".equalsIgnoreCase(userrole)) {
				    CookiesUtil.addCookie(resp, "role", "admin", 10 * 30);
				    resp.sendRedirect(req.getContextPath() + "/dashboard"); // Redirect to /dashboard
				} else {
					CookiesUtil.addCookie(resp, "role", "user", 10 * 30);
					resp.sendRedirect(req.getContextPath() + "/home"); // Redirect to /home
				}
			} else {
				handleLoginFailure(req, resp, loginStatus);
			}
		} else {
			redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please fill all the fields!",
					RedirectionUtil.loginUrl);
		}
	}
	
	
	/**
	 * Handles login failures by setting attributes and forwarding to the login
	 * page.
	 *
	 * @param req         HttpServletRequest object
	 * @param resp        HttpServletResponse object
	 * @param loginStatus Boolean indicating the login status
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
			throws ServletException, IOException {
		String errorMessage;
		if (loginStatus == null) {
			errorMessage = "Our server is under maintenance. Please try again later!";
		} else {
			errorMessage = "User credential mismatch. Please try again!";
		}
		req.setAttribute("error", errorMessage);
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}


}
