<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
    <h1 class="heading">Welcome to Urban Cam Store</h1>
    <div class="container">
        <h2>Register</h2>
        
          <%-- Error or success messages --%>
        <%
            String errorMessage = (String) request.getAttribute("error");
            String successMessage = (String) request.getAttribute("success");

            if (errorMessage != null && !errorMessage.isEmpty()) {
 				out.println("<p class=\"error-message\">" + errorMessage + "</p>");

            }

            if (successMessage != null && !successMessage.isEmpty()) {
        %>
            <p class="success-message"><%= successMessage %></p>
        <%
            }
        %>
        
        <form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" name="Name" placeholder="Name" required>
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="Password" required>
                <input type="password" name="retypePassword" placeholder="Confirm Password" required>
            </div>
            <div class="form-group">
                <input type="tel" name="userNumber" placeholder="Phone Number" required>
                <input type="date" name="dob" required>          
            </div>
            <select class = "dropDown" name="gender" required>
                    <option value="" disabled selected>Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
             </select>
              <div class="img">                
                    <label for="image">Profile Picture:</label>
                    <input type="file" id="image" name="image">
            </div>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>