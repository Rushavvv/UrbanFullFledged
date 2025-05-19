<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photography Profile</title>
    <link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/about.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/footer.css">
	<link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="about">
            <h2 class="header">MEET THE TEAM</h2>
            
            <div class="about-text">
                We are a collective of visionaries, creators, and storytellers. United by our passion for cameras, we transform moments into timeless pictures.
            </div>
            
            <div class="flex-container1">
                <div class="Srk">
                    <img src="${pageContext.request.contextPath}/resources/images/teamMember1.jpg" alt="Shah Rukh Khan">
                    <br>
                    Shah Rukh Khan
                    <div class="team-member-title">Creative Director</div>
                </div>

                <div class="Pewds">
                    <img src="${pageContext.request.contextPath}/resources/images/teamMember2.jpg" alt="Felix Kjellberg">
                    <br>
                    Felix Kjellberg
                    <div class="team-member-title">Lead Photographer</div>
                </div>

                <div class="Mark">
                    <img src="${pageContext.request.contextPath}/resources/images/teamMember3.jpg" alt="Mark Fishbach">
                    <br>
                    Mark Fishbach
                    <div class="team-member-title">Visual Designer</div>
                </div>
            </div>
        </div>
    </div>
</body>
    <!-- Footer -->
    <jsp:include page="footer.jsp"/>
