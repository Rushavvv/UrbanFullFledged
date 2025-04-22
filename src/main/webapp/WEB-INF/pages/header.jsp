<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="jakarta.servlet.http.HttpServletRequest"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav>
        <div class="dropdown">
            <button class="dropbtn"> Menu</button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
                <a href="#">Option 2</a>
                <a href="#">Option 3</a>
            </div>
        </div>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
        
        <div class="name">Urban</div>
    </nav> --%>