<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <div class="login-container">
   
        <h1>Login</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" name = "userName" placeholder="Username" required>
            <input type="password" name = "password" placeholder="Password" required>
            <%
				String errorMessage = (String) request.getAttribute("error");
				String successMessage = (String) request.getAttribute("success");
		
				if (errorMessage != null && !errorMessage.isEmpty()) {
					out.println("<p class=\"error-message\">" + errorMessage + "</p>");
				}
		
				if (successMessage != null && !successMessage.isEmpty()) {
				%>
				<p class="success-message"><%=successMessage%></p>
				<%
				}
			%>
            <button type="submit">Login</button>
            <h3>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register</a> </h3>             
        </form>

    </div>
    
</body>
</html>
