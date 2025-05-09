<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Urban</title>
<link rel="stylesheet" type="text/css"
		 href="${contextPath}/css/adminControl.css">
</head>
<body>
  <div class="navbar">
    <div class="nav-items">
      <a href="#">Menu</a>
      <a href="#">Home</a>
      <a href="#">About</a>
      <a href="#">Profile</a>
    </div>
    <div class="logo">Urban</div>
    <a href="#" class="logout-btn">Logout</a>
  </div>
  
  <div class="container">
    <h1>Admin Dashboard</h1>
    
    <div class="admin-panel">
      <div class="panel-header">
        <div class="panel-title">Product Management</div>
        <div class="search-bar">
          <input type="text" placeholder="Search products...">
          <button>Search</button>
        </div>
      </div>
      
      <div class="action-buttons">
        <button class="action-btn primary">Add New Product</button>
      </div>
      
      <table class="products-table">
        <thead>
          <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>In Stock</th>
            <th>Price</th>
            <th>Actions</th>
          </tr>
        </thead>
         <tbody>
          <c:forEach var="product" items="${products}">
			  <tr>
			    <td><c:out value="${product.productId}" /></td>
			    <td><c:out value="${product.productName}" /></td>
   			    <td><c:out value="${product.inStock}" /></td>
			    <td><c:out value="${product.productPrice}" /></td>
			    <td>
			      <div class="action-buttons">
			        <a href="editUser.jsp?email=${product.productId}" class="btn btn-primary">Edit</a>
        			<a href="${pageContext.request.contextPath}/delete?email=${product.productId}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
			      </div>
			    </td>
			  </tr>
			</c:forEach>
        </tbody>
      </table>
      
    </div>
  </div>
</body>
</html>