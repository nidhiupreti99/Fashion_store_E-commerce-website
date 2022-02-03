<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>'
<head>
<style>
.grid-container{
display:grid;
grid-template-columns: auto auto auto;
padding:10px;
}
.grid-item{
padding:20px;
text-align:center;
margin:0;
height:400px;
width:400px;
}

img{

height:200px;
width:200px;
}


</style>

</head>
<div class="grid-container">

<c:forEach items="${productList}" var = "product">
<div class="grid-item">
<a href="<c:url value="/totalProductDisplay/${product.productId}"/>" class="thumbnail">
<img src="<c:url value="/resources/images/${product.productId}.jpg" />" alt="Generic Placeholder">
</a>
<p align= "center">${product.productName}</p>
<p align= "center"> Price:${product.price}</p>
<p align= "center"> Stock: ${product.stock}</p>


</div>
</c:forEach>
</div>