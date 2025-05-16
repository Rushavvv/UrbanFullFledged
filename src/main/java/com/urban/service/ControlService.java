package com.urban.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		System.out.println("Delete called");
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

	public boolean addProduct(ProductsModel product) {
	    String query = "INSERT INTO Products (productName, productPrice, inStock) VALUES (?, ?, ?)";

	    try (Connection conn = DbConfig.getDbConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, product.getProductName());
	        stmt.setDouble(2, product.getProductPrice());
	        stmt.setInt(3, product.getInStock());

	        return stmt.executeUpdate() > 0;

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public boolean updateProduct(ProductsModel product) {
        boolean result = false;
        String sql = "UPDATE products SET productName = ?, productPrice = ?, inStock = ? WHERE productId = ?";

        try (Connection conn = DbConfig.getDbConnection();  
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getProductPrice());
            stmt.setInt(3, product.getInStock());
            stmt.setInt(4, product.getProductId());

            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	
	public ProductsModel binarySearchProductByName(String name) {
	    List<ProductsModel> allProducts = getAllProductDetails();

	    allProducts.sort(Comparator.comparing(ProductsModel::getProductName, String.CASE_INSENSITIVE_ORDER));

	    int left = 0;
	    int right = allProducts.size() - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        ProductsModel midProduct = allProducts.get(mid);
	        int comparison = midProduct.getProductName().compareToIgnoreCase(name);

	        if (comparison == 0) {
	            return midProduct; // Match found
	        } else if (comparison < 0) {
	            left = mid + 1; // Search right half
	        } else {
	            right = mid - 1; // Search left half
	        }
	    }

	    return null; // Not found
	}

}
