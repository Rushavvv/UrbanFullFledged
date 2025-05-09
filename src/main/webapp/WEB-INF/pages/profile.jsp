<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
        
        <!-- Main content -->
        <div class="main">
            <div class="profile-image-container">
                <div class="profile-circle">
                    <img src="${pageContext.request.contextPath}/resources/images/${user.imageUrl}" alt="Profile" class="profile-image">
                </div>
            </div>
            
			<div class="profile-content">
			    <h1 class="welcome-title">Welcome, <c:out value="${user.userName}" /></h1>
			    <h2>Manage your profile however you want (๑´• .̫ •ू`๑)</h2>
			    <h2 class="profile-description">
                    <strong>Your Email:</strong> <c:out value="${user.userEmail}" /><br>
                    <strong>Your Phone Number:</strong> <c:out value="${user.userNumber}" /><br>
                </h2>
			</div>
        </div>
        
        <!-- Footer -->
        <%-- jsp:include page="footer.jsp" /> --%>
    </div>
</body>
</html>