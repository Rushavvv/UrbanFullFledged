<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photography Profile</title>
    <link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/profile.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
   	 <div class="container">     
        
         <div class="about">
            <hr color="white">
            <hr color="white">
            <h2 class="header"> Meet The Team </h2>
            <div class="flex-container1">
              <div class="Rushav">
                <a href="../images/Resume.pdf">
                <img src="me.jpg">
                <br>
                Rushav
                </a>
              </div>

              <div class="Sulav">
                <a href="../images/AnshumanCV.pdf">
                <img src="about2.jpg">
                Sulav
                </a>
              </div>
              

              <div class="Hari">
                <a href="../images/C.V.pdf">
                <img src="About4.jpg">
                Hari
                </a>
              </div>

            </div>
            <hr color="white">
            <hr color="white">
            
        </div>
        <!-- Footer -->
        <jsp:include page="footer.jsp"/>
    </div>
</body>
</html>