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
		<form>
            <input type="text" placeholder="Username" required>
            <input type="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <h3>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register</a> </h3>             
        </form>
    </div>
</body>
</html>
