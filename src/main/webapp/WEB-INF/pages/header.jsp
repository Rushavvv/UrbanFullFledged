 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<%
    // Initialize necessary objects and variables
    HttpSession userSession = request.getSession(false);
    String currentUser = (String) (userSession != null ? userSession.getAttribute("username") : null);
    // need to add data in attribute to select it in JSP code using JSTL core tag
    pageContext.setAttribute("currentUser", currentUser);
%>
<!-- Set contextPath variable -->
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<link rel="stylesheet" type="text/css"
		 href="${contextPath}/css/header.css">

<nav>
        <div class="dropdown">
            <button class="dropbtn"> Menu</button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
                <a href="${pageContext.request.contextPath}/adminControl">Product Control</a>
            </div>
        </div>
        <a href="home">Home</a>
        <a href="about">About</a>
        <a href="profile">Profile</a>
        <a href="productsPage">Products</a>
        
        
        <c:choose>
		    <c:when test="${not empty currentUser}">
		        <form action="${pageContext.request.contextPath}/logout" method="post" class="logout-form">
		            <button type="submit" class="logout-button">Logout</button>
		        </form>
		    </c:when>
		    <c:otherwise>
		        <a href="${pageContext.request.contextPath}/logout">Logout</a>
		    </c:otherwise>
		</c:choose>
		
		<h1 class="urban">Urban</h1>
    </nav>  