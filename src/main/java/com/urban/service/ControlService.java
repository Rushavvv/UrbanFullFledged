package com.urban.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.urban.config.DbConfig;
import com.urban.model.ProductsModel;

public class ControlService {
	
	private Connection dbConn;
	private boolean isConnectionError = false;

	
	public ControlService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			// Log and handle exceptions related to database connection
			ex.printStackTrace();
			isConnectionError = true;
		}
	}
	
	
	public List<ProductsModel> getAllProductDetails() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT * FROM Products";
		try (PreparedStatement stmt = dbConn.prepareStatement(query);
		     ResultSet rs = stmt.executeQuery()) {

			List<ProductsModel> productList = new ArrayList<>();
			while (rs.next()) {
				productList.add(new ProductsModel(
					rs.getInt("productId"),
					rs.getString("productName"),
					rs.getInt("productPrice"),
					rs.getInt("inStock")
				));
			}
			return productList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean deleteProductById(int productId) {
		if (productId <= 0) return false;

		String query = "DELETE FROM Products WHERE productId = ?";
		try (Connection conn = DbConfig.getDbConnection();
			 PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setInt(1, productId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	

}
