<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
    <nav>
        <div class="dropdown">
            <button class="dropbtn"> Menu</button>
            <div class="dropdown-content">
                <a href="#">Option 1</a>
                <a href="#">Option 2</a>
                <a href="#">Option 3</a>
            </div>
        </div>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
        
        <div class="name">Urban</div>
    </nav>
    <div class="container">
    	
        <img class="image1" src="${pageContext.request.contextPath}/resources/images/Picture2.png" alt="Camera1">
        <h1>Welcome</h1>     
        <p>Shop digital camera products and camera bundles at Urban. 
            We carry a vast selection of Digital Cameras, Mirrorless Cameras, and Digital Camera Kits.</p>

    </div>

    <div class="second-container">
        <h1>Best Quality</h1>
        <p>Get the best quality products at Urban. 
            We import from genuine dealers and ensure top notch quality to all our customers with guarantee.
        </p>
        <img class="image2" src="${pageContext.request.contextPath}/resources/images/Picture1.png" alt="Camera2">
    </div>

    

</body>

<footer class="footer">
    <div class="footer-container">
      <div class="footer-logo">
      </div>
      <div class="footer-links">
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Contact</a>
      </div>
    </div>
    <div class="footer-bottom">
      <p> 2025 Urban. All rights reserved.</p>
    </div>
</footer>
</html>