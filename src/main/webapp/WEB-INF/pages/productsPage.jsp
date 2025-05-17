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
            <!-- Product 1 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product1.jpg" alt="Fine Art Print" class="product-image">
                <div class="product-details">
                    <div class="product-category">Prints</div>
                    <h3 class="product-title">Rode Mic 360</h3>
                    <p class="product-description">Rode mic 360 best sound quality 320 Hz with dual channel.</p>
                    <div class="product-price">Rs. 12000</div>
                    <div class="product-footer">
                        <span class="product-availability">In Stock</span>
                    </div>
                </div>
            </div>
            
            <!-- Product 2 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product2.jpg" alt="Metal Print" class="product-image">
                <div class="product-details">
                    <div class="product-category">Prints</div>
                    <h3 class="product-title">Metal Print</h3>
                    <p class="product-description">Stunning metal prints with vibrant colors and exceptional durability.</p>
                    <div class="product-price">Rs. 18000</div>
                    <div class="product-footer">
                        <span class="product-availability">In Stock</span>
                    </div>
                </div>
            </div>
            
            <!-- Product 3 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product3.jpg" alt="Framed Print" class="product-image">
                <div class="product-details">
                    <div class="product-category">Prints</div>
                    <h3 class="product-title">Framed Gallery Print</h3>
                    <p class="product-description">Custom framed prints with acid-free mats and premium hardwood frames.</p>
                    <div class="product-price">Rs. 25000</div>
                    <div class="product-footer">
                        <span class="product-availability">In Stock</span>
                    </div>
                </div>
            </div>
            
            <!-- Product 4 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product4.jpg" alt="Digital License" class="product-image">
                <div class="product-details">
                    <div class="product-category">Digital</div>
                    <h3 class="product-title">Commercial License</h3>
                    <p class="product-description">Commercial usage license for selected high-resolution digital images.</p>
                    <div class="product-price">Rs. 35000</div>
                    <div class="product-footer">
                        <span class="product-availability">Digital Download</span>
                    </div>
                </div>
            </div>
            
            <!-- Product 5 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product5.jpg" alt="Photo Session" class="product-image">
                <div class="product-details">
                    <div class="product-category">Services</div>
                    <h3 class="product-title">Portrait Session</h3>
                    <p class="product-description">Professional portrait photography session with digital delivery.</p>
                    <div class="product-price">Rs. 45000</div>
                    <div class="product-footer">
                        <span class="product-availability">Available</span>
                    </div>
                </div>
            </div>
            
            <!-- Product 6 -->
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/product6.jpg" alt="Photography Course" class="product-image">
                <div class="product-details">
                    <div class="product-category">Services</div>
                    <h3 class="product-title">Photography Workshop</h3>
                    <p class="product-description">Hands-on photography workshop for all skill levels with field sessions.</p>
                    <div class="product-price">Rs. 27500</div>
                    <div class="product-footer">
                        <span class="product-availability">Limited Spots</span>
                    </div>
                </div>
            </div>
        </div>


    </div>
      <jsp:include page="footer.jsp"/>
    
</body>

</html>