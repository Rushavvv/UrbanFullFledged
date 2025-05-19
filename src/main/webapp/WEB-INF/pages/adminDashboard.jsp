<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/adminDashboard.css">
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <jsp:include page="header.jsp"/>
    
    <div class="stats">
      <h1 class="activity"> Recent Activity </h1>
      <div class="stats-cards">
        <div class="stat-card">
          <h3>TOTAL USERS</h3>
		  <div class="value"><c:out value="${totalUsers}" /></div>
          <div class="trend up">
            <span>Total Users In The System</span>
            <img class="image2" src="${pageContext.request.contextPath}/resources/images/dashboardImg1.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>TOTAL REVENUE</h3>
		  <div class="value">Rs.<c:out value="${totalRevenue}" /></div>
          <div class="trend up">
            <span>Total Profits Earned</span>
            <img class="image1" src="${pageContext.request.contextPath}/resources/images/dashboardImg2.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>ACTIVE PRODUCTS</h3>
		  <div class="value"><c:out value="${activeProducts}" /></div>
          <div class="trend down">
            <span>Products Currently In Stock</span>
            <img class="image3" src="${pageContext.request.contextPath}/resources/images/dashboardImg3.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>OUT OF STOCK</h3>
		  <div class="value"><c:out value="${outOfStock}" /></div>
          <div class="trend down">
            <span>Products Currently Out Of Stock</span>
            <img class="image3" src="${pageContext.request.contextPath}/resources/images/dashboardImg5.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>Expected Profits</h3>
		  <div class="value">Rs. <c:out value="${profitMargin}"/></div>
          <div class="trend down">
            <span>Expected Profit Margin This Month</span>
            <img class="image3" src="${pageContext.request.contextPath}/resources/images/dashboardImg4.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>Total Orders</h3>
		  <div class="value"><c:out value="${totalOrders}" /></div>
          <div class="trend down">
            <span>Total Orders This Month</span>
            <img class="image3" src="${pageContext.request.contextPath}/resources/images/dashboardImg6.jpg" alt="Camera2">
          </div>
        </div>
        
    </div>
    
    <div class="section-title">
      <h2>Recent Users</h2>
    </div>
    
    <div class="data-table">
      <table>
        <thead>
          <tr>
            <th>User</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="user" items="${recentUsers}">
			  <tr>
			    <td><c:out value="${user.userName}" /></td>
			    <td><c:out value="${user.userEmail}" /></td>
			    <td><c:out value="${user.gender}" /></td>
			    <td>
			      <div class="action-buttons" style="display: flex; gap: 10px;">
				    <form action="${pageContext.request.contextPath}/dashboard" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
					    <input type="hidden" name="userEmail" value="${user.userEmail}" />
					    <input type="submit" name = "action" value="Delete" class="btn btn-danger"/>
					</form>
				  </div>
			    </td>
			  </tr>
			</c:forEach>
        </tbody>
      </table>
    </div>
  </div>

</body>
</html>