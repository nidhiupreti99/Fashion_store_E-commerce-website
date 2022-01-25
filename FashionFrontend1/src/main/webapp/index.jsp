<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp" %>
<body>
<div class="container">
<h2>Home Page!</h2>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!-- -indicators -->
<ol class="carousel-indicators">
<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
<li data-target="#myCarousel" data-slide-to="1" class="active"></li>
<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
</ol>

<!-- --------Wrapper for slides ------->

<div class="acrousel-inner">
<div class="item actve">
<img src="<c:url value='resources/images/Big bazaar.jpg' />" alt="Los Angeles" style="width:100%;">
</div>

<div class="item">
<img src="<c:url value='resources/images/wc-banner.jpg' />" alt="Chicago" style="width:100%;">
</div>

<div class="item">
<img src="<c:url value='resources/images/winter ware.jpg' />" alt="Chicago" style="width:100%;">
</div>

<div class="item">
<img src="<c:url value='resources/images/mobile.jpg' />" alt="Chicago" style="width:100%;">
</div>

<div class="item">
<img src="<c:url value='resources/images/shoes.jpg' />" alt="Chicago" style="width:100%;">
</div>

<div class="item">
<img src="<c:url value='resources/images/Big bazaar.jpg' />" alt="New York" style="width:100%;">
</div>
</div>

<!-- -----"left carousel-control -->

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicom-chevron-left"></span>
<span class="sr-only">Previous</span>
</a>

<a class="right carousel-control" href="#myCarousel" data-slide="next">
<span class="glyphicon glyphicom-chevron-right"></span>
<span class="sr-only">Next</span>
</a>

</div>

</div>
<h2>Home Page</h2>
</body>
</html>
