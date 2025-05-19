<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/editProfile.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">
    <h1>Edit Profile</h1>

    <div class="form-container">
        <div class="form-title">Profile Information</div>

        <form id="editProfileForm" action="${pageContext.request.contextPath}/editProfile" method="post" enctype="multipart/form-data">
    
    <div class="form-group">
        <label for="fullName">Full Name<span class="required">*</span></label>
        <input type="text" id="userName" name="userName" class="form-control" required
               value="<c:out value='${sessionScope.fullName}'/>">
        <div class="form-text">Enter your full name</div>
    </div>

    <div class="form-group">
        <label for="email">Email<span class="required">*</span></label>
        <input type="email" id="userEmail" name="userEmail" class="form-control" required
               value="<c:out value='${sessionScope.email}'/>">
        <div class="form-text">Enter your email address</div>
    </div>

    <div class="form-group">
        <label for="phone">Phone Number<span class="required">*</span></label>
        <input type="tel" id="userNumber" name="userNumber" class="form-control" required
               pattern="[0-9]{10}" value="<c:out value='${sessionScope.phone}'/>">
        <div class="form-text">Enter a 10-digit phone number</div>
    </div>

    <div class="form-group">
        <label for="password">New Password<span class="required">*</span></label>
        <input type="password" id="password" name="password" class="form-control" required>
        <div class="form-text">Enter your new password</div>
    </div>

    <div class="form-group">
        <label for="image">Profile Picture</label>
        <input type="file" id="image" name="image" class="form-control">
        <div class="form-text">Upload a new profile picture (optional)</div>
    </div>

    <div class="action-buttons" style="display: flex; gap: 10px; margin-top: 20px;">
        <input type="submit" value="Update Profile" class="btn btn-primary" />
        <a href="${pageContext.request.contextPath}/profile" class="btn btn-secondary">Cancel</a>
    </div>
</form>

    </div>
</div>

</body>
</html>
