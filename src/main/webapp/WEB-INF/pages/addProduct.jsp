<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addProduct.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Add Product</h1>

    <div class="form-container">
        <div class="form-title">Product Information</div>

        <!-- FORM: Send to ControlController -->
        <form id="addProductForm" action="${pageContext.request.contextPath}/adminControl" method="post">
            <input type="hidden" name="action" value="Add" />
            
            <div class="form-group">
                <label for="productId">Product ID<span class="required">*</span></label>
                <input type="text" id="productId" name="productId" class="form-control" required>
                <div class="form-text">Enter the product Id</div>
            </div>

            <div class="form-group">
                <label for="productName">Product Name<span class="required">*</span></label>
                <input type="text" id="productName" name="productName" class="form-control" required>
                <div class="form-text">Enter the full name of the product</div>
            </div>

            <div class="form-group">
                <label for="productPrice">Product Price (Rs.)<span class="required">*</span></label>
                <input type="number" id="productPrice" name="productPrice" class="form-control" step="0.01" min="0" required>
                <div class="form-text">Enter the price in Rupees</div>
            </div>

            <div class="form-group">
                <label for="inStock">In Stock Quantity<span class="required">*</span></label>
                <input type="number" id="inStock" name="inStock" class="form-control" min="0" required>
                <div class="form-text">Enter the number of units in inventory</div>
            </div>

            <div class="action-buttons" style="display: flex; gap: 10px; margin-top: 20px;">
                <input type="submit" value="Add Product" class="btn btn-primary" />
                <a href="${pageContext.request.contextPath}/control" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
