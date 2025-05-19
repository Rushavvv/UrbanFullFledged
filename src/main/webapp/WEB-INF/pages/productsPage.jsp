<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photography Products</title>
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/productsPage.css">
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" type="text/css"
	 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>

	<jsp:include page="header.jsp"/>
	
    <div class="container">
        <!-- Page Header -->
        <header class="page-header">
            <h1 class="page-title">Photography Products</h1>
            <p class="page-description">Browse our collection of premium photography products, prints, and services.</p>
        </header>

        <!-- Products Grid -->
	        <div class="products-grid">
		    <c:forEach var="product" items="${products}">
		        <div class="product-card">
		            <img src="${pageContext.request.contextPath}/resources/images/product${product.productId}.jpg"
		                 alt="${product.productName}" class="product-image">
		            <div class="product-details">
		                <div class="product-category">Category</div>
		                <h3 class="product-title">${product.productName}</h3>
		                <p class="product-description">Static product description here</p>
		                <div class="product-price">Rs. ${product.productPrice}</div>
		                <div class="product-footer">
		                    <span class="product-availability">
		                        <c:choose>
		                            <c:when test="${product.inStock > 0}">In Stock</c:when>
		                            <c:otherwise>Out of Stock</c:otherwise>
		                        </c:choose>
		                    </span>
		                </div>
		            </div>
		        </div>
		    </c:forEach>
		</div>
	</div>
      <jsp:include page="footer.jsp"/>
    
</body>

</html>