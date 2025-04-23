<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/home.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
    	
        <img class="image1" src="${pageContext.request.contextPath}/resources/images/Picture3.png" alt="Camera1">
        <h1>Welcome</h1>     
        <p>Shop digital camera products and camera bundles at Urban. 
            We carry a vast selection of Digital Cameras, Mirrorless Cameras, and Digital Camera Kits. 
            Find what you're looking for from cameras to tripods, we have it all</p>

    </div>
    
    <div class="product-section">
        <div class="product-card">
            <img src="${pageContext.request.contextPath}/resources/images/prod1.jpg" alt="Camera A">
            <h3>Camera A</h3>
            <p>High-resolution DSLR with powerful zoom lens.</p>
        </div>
        <div class="product-card">
            <img src="${pageContext.request.contextPath}/resources/images/prod2.jpg" alt="Camera B">
            <h3>Camera B</h3>
            <p>Compact mirrorless camera perfect for vlogging.</p>
        </div>
        <div class="product-card">
            <img src="${pageContext.request.contextPath}/resources/images/prod3.jpg" alt="Camera C">
            <h3>Camera C</h3>
            <p>4K action camera for adventure seekers.</p>
        </div>
    </div>

    <div class="second-container">
        <h1>Best Quality</h1>
        <p>Get the best quality products at Urban. 
            We import from genuine dealers and ensure top notch quality to all our customers with guarantee.
            Get the best quality items at the best prices. Shop at Urban!!
        </p>
        <img class="image2" src="${pageContext.request.contextPath}/resources/images/Picture1.png" alt="Camera2">
    </div>

</body>

 <jsp:include page="footer.jsp" />
</html>