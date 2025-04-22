package com.urban.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.urban.config.DbConfig;
import com.urban.model.ProductsModel;
import com.urban.model.UserModel;

/**
 * Service class for interacting with the database to retrieve dashboard-related
 * data. This class handles database connections and performs queries to fetch
 * student information.
 */
public class DashboardService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor that initializes the database connection. Sets the connection
	 * error flag if the connection fails.
	 */
	public DashboardService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			// Log and handle exceptions related to database connection
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Retrieves all student information from the database.
	 * 
	 * @return A list of StudentModel objects containing student data. Returns null
	 *         if there is a connection error or if an exception occurs during query
	 *         execution.
	 */
	public List<UserModel> getAllUserInfo() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		// SQL query to fetch user details
		String query = "SELECT user_id, userName, userNumber, userEmail, gender, role FROM User";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			List<UserModel> userList = new ArrayList<>();

			while (result.next()) {
				// SQL query to fetch program name based on program_id
				String programQuery = "SELECT productId, productName FROM Products WHERE productId = ?";
				try (PreparedStatement programStmt = dbConn.prepareStatement(programQuery)) {
					programStmt.setInt(1, result.getInt("productId"));
					ResultSet programResult = programStmt.executeQuery();

					ProductsModel productsModel = new ProductsModel();
					if (programResult.next()) {
						// Set program name in the ProgramModel
						productsModel.setProductName(programResult.getString("productName"));
						productsModel.setProductId(programResult.getInt("productId"));
					}

					// Create and add StudentModel to the list
					userList.add(new UserModel(result.getInt("userId"), // Student ID
							result.getString("userName"), // First Name
							result.getString("userNumber"), // Last Name
							result.getString("userEmail"), // Email
							result.getString("gender") // Phone Number
					));

					programResult.close(); // Close ResultSet to avoid resource leaks
				} catch (SQLException e) {
					// Log and handle exceptions related to program query execution
					e.printStackTrace();
					// Continue to process other students or handle this error appropriately
				}
			}
			return userList;
		} catch (SQLException e) {
			// Log and handle exceptions related to student query execution
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateStudent(UserModel user) {
		if (isConnectionError)
			return false;

		String updateQuery = "UPDATE User SET userName = ?, userNumber = ?, userEmail = ?, gender = ?, role = ? WHERE userId = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(updateQuery)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserNumber());
			stmt.setString(3, user.getUserEmail());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getRole());
			
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteuser(int userId) {
		if (isConnectionError)
			return false;

		String deleteQuery = "DELETE FROM User WHERE userId = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
			stmt.setInt(1, userId);

			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getProductName(int id) {
		if (isConnectionError)
			return null;

		String deleteQuery = "select productName from Products where productId = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
			stmt.setInt(1, id);

			ResultSet result = stmt.executeQuery();
			if (result.next())
				return result.getString("productName");
			else
				return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}