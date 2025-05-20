package com.urban.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.urban.config.DbConfig;
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
	 * Retrieves all user information from the database.
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
		String query = "SELECT userName, userNumber, userEmail, gender FROM User ORDER BY userId DESC LIMIT 5";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			List<UserModel> userList = new ArrayList<>();

			while (result.next()) {
				userList.add(new UserModel(
						result.getString("userName"), 
						result.getString("userNumber"), 
						result.getString("userEmail"), 
						result.getString("gender") 
				));
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateUser(UserModel user) {
		if (isConnectionError)
			return false;

		String updateQuery = "UPDATE User SET userName = ?, userNumber = ?, userEmail = ?, gender = ? WHERE userId = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(updateQuery)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserNumber());
			stmt.setString(3, user.getUserEmail());
			stmt.setString(4, user.getGender());
			
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
	
	public int getTotalUsers() {
		if (isConnectionError) return 0;

		String query = "SELECT COUNT(*) AS total FROM User";
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalRevenue() {
		if (isConnectionError) return 0;

		String query = "SELECT SUM(totalPrice) AS totalRevenue FROM Sales"; 
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("totalRevenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getActiveProducts() {
		if (isConnectionError) return 0;

		String query = "SELECT COUNT(*) AS total FROM Products"; 
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean deleteUserByEmail(String email) {
		if (isConnectionError)
			return false;

		String deleteQuery = "DELETE FROM User WHERE userEmail = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
			stmt.setString(1, email);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUserProfile(String userName, String userEmail, String userNumber, String password, String imagePath) {
	    if (isConnectionError)
	        return false;

	    String sql = "UPDATE User SET userEmail = ?, userNumber = ?, password = ?, image_path = ? WHERE userName = ?";
	    try (PreparedStatement stmt = dbConn.prepareStatement(sql)) {
	        stmt.setString(1, userEmail);
	        stmt.setString(2, userNumber);
	        stmt.setString(3, password); 
	        stmt.setString(4, imagePath);
	        stmt.setString(5, userName);

	        int rowsUpdated = stmt.executeUpdate();
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public int getOutOfStockProducts() {
		if (isConnectionError) return 0;

		String query = "SELECT COUNT(*) AS total FROM Products WHERE inStock = 0";
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getAverageOrderValue() {
		if (isConnectionError) return 0;

		String query = "SELECT AVG(totalPrice) AS avgOrder FROM Sales";
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("avgOrder");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getTotalOrders() {
	    int totalOrders = 0;
	    String sql = "SELECT COUNT(*) FROM Sales";

	    try (
	         PreparedStatement stmt = dbConn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        if (rs.next()) {
	            totalOrders = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalOrders;
	}

}