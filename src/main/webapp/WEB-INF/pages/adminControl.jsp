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
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
  <jsp:include page="header.jsp"/>

  
  <div class="container">
    <h1>Admin Dashboard</h1>
    
    <div class="admin-panel">
      <div class="panel-header">
        <div class="panel-title">Product Management</div>
        <div class="search-bar">
          <form action="${pageContext.request.contextPath}/adminControl" method="get" style="margin-bottom: 20px;">
		    <input type="text" name="Search" placeholder="Search product" />
		    <input type="submit" value="Search" />
		  </form>
        </div>
      </div>
      
      <table>
	  <tr>
	    <!-- Add New Product Button -->
	    <td>
	      <div class="action-buttons">
	        <a href="${contextPath}/addProduct">
	          <button class="action-btn primary">Add New Product</button>
	        </a>
	      </div>
	    </td>
	
	    <!-- Edit Product Button -->
	    <td>
	     <div class="action-buttons">
	      <a href= "${contextPath}/editProduct">
	        <button class="action-btn primary">Edit Product</button>
	       </a>
	      </div>
	    </td>
	  </tr>
	</table>
      
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
			     <div class="action-buttons" style="display: flex; gap: 10px;">
				    <form action="${pageContext.request.contextPath}/adminControl" method="post" onsubmit="return confirm('Are you sure you want to delete this product?');">
					    <input type="hidden" name="productId" value="${product.productId}" />
					    <input type="submit" name = "action" value="Delete" class="btn btn-danger"/>
					</form>
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