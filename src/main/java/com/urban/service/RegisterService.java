package com.urban.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.urban.config.DbConfig;
import com.urban.model.UserModel;

public class RegisterService {
	private Connection dbConn;

	/**
	 * Constructor initializes the database connection.
	 */
	public RegisterService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public Boolean addUser(UserModel userModel) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String insertQuery = "INSERT INTO User (userName, userNumber, userEmail, gender, role, password, image_path)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try(PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {

			// Insert student details
			insertStmt.setString(1, userModel.getUserName());
			insertStmt.setString(2, userModel.getUserNumber());
			insertStmt.setString(3, userModel.getUserEmail());
			insertStmt.setString(4, userModel.getGender());
			insertStmt.setString(5, userModel.getRole());
			insertStmt.setString(6, userModel.getPassword());
			insertStmt.setString(7, userModel.getImageUrl());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during student registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
