package com.urban.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.urban.config.DbConfig;
import com.urban.model.UserModel;
import com.urban.util.PasswordUtil;

/**
 * Service class for handling login operations. Connects to the database,
 * verifies user credentials, and returns login status.
 * @author Rushav Sthapit
 */
public class LoginService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public LoginService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Validates the user credentials against the database records.
	 *
	 * @param studentModel the StudentModel object containing user credentials
	 * @return true if the user credentials are valid, false otherwise; null if a
	 *         connection error occurs
	 */
	public Boolean loginUser(UserModel userModel) {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}
		
		String query = "SELECT userName, password FROM User WHERE userName = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			stmt.setString(1, userModel.getUserName());
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return validatePassword(result, userModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return false;
	}
	
	public UserModel getUserDetails(String username) {
	    UserModel user = null;
	    try (Connection conn = DbConfig.getDbConnection();
	         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE userName = ?")) {
	        
	        stmt.setString(1, username);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            user = new UserModel();
	            user.setUserName(rs.getString("userName"));
	            user.setUserEmail(rs.getString("userEmail"));
	            user.setUserNumber(rs.getString("userNumber"));
	            user.setImageUrl(rs.getString("image_path"));
	        }
	        
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return user;
	}
	
	public String getUserRole(String username) {
	    if (isConnectionError) {
	        System.out.println("Connection Error!");
	        return null;
	    }

	    String query = "SELECT role FROM User WHERE userName = ?";
	    try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
	        stmt.setString(1, username);
	        ResultSet result = stmt.executeQuery();

	        if (result.next()) {
	            return result.getString("role");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}


	/**
	 * Validates the password retrieved from the database. 
	 *
	 * @param result       the ResultSet containing the username and password from
	 *                     the database
	 * @param studentModel the StudentModel object containing user credentials
	 * @return true if the passwords match, false otherwise
	 * @throws SQLException if a database access error occurs
	 */
	private boolean validatePassword(ResultSet result, UserModel userModel) throws SQLException {
		String dbUsername = result.getString("userName");
		String dbPassword = result.getString("password");
		return dbUsername.equals(userModel.getUserName())
				&& PasswordUtil.decrypt(dbPassword, dbUsername).equals(userModel.getPassword());
	}
}
