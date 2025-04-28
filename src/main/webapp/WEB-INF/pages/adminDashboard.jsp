<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <jsp:include page="header.jsp" />
    
    <div class="stats">
      <h1 class="activity"> Recent Activity </h1>
      <div class="stats-cards">
        <div class="stat-card">
          <h3>TOTAL USERS</h3>
          <div class="value">2,543</div>
          <div class="trend up">
            <span>Total Users In The System</span>
            <img class="image2" src="${pageContext.request.contextPath}/resources/images/dashboardImg1.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>TOTAL REVENUE</h3>
          <div class="value">Rs.45,243</div>
          <div class="trend up">
            <span>Total Profits Earned</span>
            <img class="image1" src="${pageContext.request.contextPath}/resources/images/dashboardImg2.jpg" alt="Camera2">
          </div>
        </div>
        
        <div class="stat-card">
          <h3>ACTIVE PRODUCTS</h3>
          <div class="value">156</div>
          <div class="trend down">
            <span>Products Currently In Stock</span>
            <img class="image3" src="${pageContext.request.contextPath}/resources/images/dashboardImg3.jpg" alt="Camera2">
          </div>
        </div>
        
        
    </div>
    
    <div class="section-title">
      <h2>Recent Users</h2>
      <div class="view-all">View All</div>
    </div>
    
    <div class="data-table">
      <table>
        <thead>
          <tr>
            <th>User</th>
            <th>Email</th>
            <th>Role</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Rushav Sthapit</td>
            <td>rusu.sthapit@gmail.com</td>
            <td>Admin</td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Ben Dover</td>
            <td>ben@gmail.com</td>
            <td>User</td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Billu Adhikari</td>
            <td>billu@gmail.com</td>
            <td>User</td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Lisa Brown</td>
            <td>lisa.brown@gmail.com</td>
            <td>User</td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Sundar Einstein jr</td>
            <td>einstein@gmail.com</td>
            <td>Admin</td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

</body>

 <jsp:include page="footer.jsp" />
</html>