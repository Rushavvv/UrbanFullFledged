<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/adminDashboard.css">
</head>
<body>
  	
    <nav>
        <div class="dropdown">
            <button class="dropbtn">☰ Menu</button>
            <div class="dropdown-content">
                <a href="#">Option 1</a>
                <a href="#">Option 2</a>
                <a href="#">Option 3</a>
            </div>
        </div>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
        <div class="logo"></div>
    </nav>
    
    <h1 class="activity"> Recent Activity </h1>
    <div class="stats-cards">
      <div class="stat-card">
        <h3>TOTAL USERS</h3>
        <div class="value">2,543</div>
        <div class="trend up">
          <span>12% from last month</span>
        </div>
      </div>
      
      <div class="stat-card">
        <h3>TOTAL REVENUE</h3>
        <div class="value">$45,243</div>
        <div class="trend up">
          <span>8% from last month</span>
        </div>
      </div>
      
      <div class="stat-card">
        <h3>ACTIVE PRODUCTS</h3>
        <div class="value">156</div>
        <div class="trend down">
          <span>3% from last month</span>
        </div>
      </div>
      
      <div class="stat-card">
        <h3>PENDING ORDERS</h3>
        <div class="value">24</div>
        <div class="trend up">
          <span>18% from last month</span>
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
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>John Doe</td>
            <td>john.doe@example.com</td>
            <td>Admin</td>
            <td><span class="status active">Active</span></td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Jane Smith</td>
            <td>jane.smith@example.com</td>
            <td>Manager</td>
            <td><span class="status active">Active</span></td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Robert Johnson</td>
            <td>robert.j@example.com</td>
            <td>User</td>
            <td><span class="status pending">Pending</span></td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Lisa Brown</td>
            <td>lisa.brown@example.com</td>
            <td>User</td>
            <td><span class="status inactive">Inactive</span></td>
            <td>
              <div class="action-buttons">
                <button class="btn">Edit</button>
                <button class="btn">Delete</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>Michael Wilson</td>
            <td>michael.w@example.com</td>
            <td>Editor</td>
            <td><span class="status active">Active</span></td>
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

</body>

<footer class="footer">
    <div class="footer-container">
	      <div class="footer-logo">
	      </div>
	    <div class="footer-bottom">
	      <p>&copy; 2025 Urban. All rights reserved.</p>
	    </div>
    </div>
</footer>
</html>