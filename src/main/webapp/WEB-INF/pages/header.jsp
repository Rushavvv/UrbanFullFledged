 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">

<nav>
        <div class="dropdown">
            <button class="dropbtn"> Menu</button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
                <a href="#">Option 2</a>
                <a href="#">Option 3</a>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <a href="#">About</a>
        <a href="${pageContext.request.contextPath}/profile">Profile</a>
        
        <div class="name">Urban</div>
    </nav>  