package com.urban.controller;
import com.urban.util.ImagePathUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rushav Sthapit
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/Picture2"})
public class Picture2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Picture2Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(ImagePathUtil.HOME_CAMERA_2).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
