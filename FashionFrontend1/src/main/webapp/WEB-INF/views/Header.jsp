<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>"${pageinfo}-Fashion</title>

<meta name=viewport content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container{
width:100%;
margin:0%;
padding:0px;
}
.navbar{
margin-left:0;
}


</style>
</head>
<body>

       <div class="container">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Fashion world</a>
				</div>
				<c:if test="${!sessionScope.loggedIn}">
				<ul class="nav navbar-nav">
				    <li><a href="<c:url value="/Login"/>">LOGIN</a></li>
					<li><a href="<c:url value="/register"/>">REGISTER</a></li>
					<li><a href="<c:url value="/aboutus"/>">ABOUT US </a></li>
					<li><a href="<c:url value="/contactus"/>">CONTACT US</a></li>
					</ul>
					</c:if>
					
					<c:if test="${sessionScope.loggedIn}">
					
					<c:if test="${sessionScope.role== 'ROLE_ADMIN'}">
				    <ul class="nav navbar-nav">
					
					<li><a href="<c:url value='/adminhome'/>">HOME</a></li>
					
					<li><a href="<c:url value='/product'/>">MANAGE PRODUCT</a></li>
					
					<li><a href="<c:url value='/category'/>">MANAGE CATEGORY</a></li>
                    <li><a href="<c:url value='/productDisplay'/>">PRODUCT CATALOG</a></li>
                    <li><a href="<c:url value='/cart'/>">CART</a></li>
                    
                    
				</ul>
				</c:if>
					<c:if test="${sessionScope.role=='ROLE_USER'}">
					<ul class="nav navbar-nav">
					<li><a href="<c:url value='/userhome'/>">HOME</a></li>
					<!-- <li class="dropdown"><a class="dorpdown-toggle" data-toggle="dropdown">CATEGORY<span class="caret"></span></a>
					
					<ul class="dropdown-menu">
					<li><a href="<c:url value='/mens'/>">Men's</a></li>
					<li><a href="<c:url value='/productDisplay'/>">Women's</a></li>
				    <li><a href="<c:url value='/productDisplay'/>">Kid's</a></li>
					</ul>
					</li>-->
					
					<li><a href="<c:url value="/aboutus"/>">ABOUT US </a></li>
					<li><a href="<c:url value="/contactus"/>">CONTACT US</a></li>
					<li><a href="<c:url value='/cart'/>">CART</a></li>
					</ul>
					</c:if>
					
				    </c:if>
				    <c:if test="${sessionScope.loggedIn}">
				    <div class="nav navbar-nav navbar-right">
				    <font color="white" face="calibri" size="2">Welcome ${sessionScope.username}</font>
				    <a href="<c:url value='/perform_logout'/>" class="btn btn-danger">LOGOUT</a>
				    </div>
				    </c:if>
				    
			</div>
		</nav>
		</div>
</body>
</html>











</body>
</html>