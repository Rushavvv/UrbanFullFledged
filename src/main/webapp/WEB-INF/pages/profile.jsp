<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Page</title>
</head>
<body>
    <h1>Welcome, ${user.userName}</h1>

    <div class="profile-section">
        <img src="${pageContext.request.contextPath}/resources/images/${user.imageUrl}" 
             alt="Profile Picture" 
             width="150" 
             height="150" />
        
        <p>Email: ${user.userEmail}</p>
        <p>Phone Number: ${user.userNumber}</p>
        <p>Gender: ${user.gender}</p>
    </div>
</body>
</html>