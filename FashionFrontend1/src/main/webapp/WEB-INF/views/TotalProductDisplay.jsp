<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<br><br>
<div align="center">
<form action="<c:url value="/addToCart/${product.productId}"/>">
<table class=" table-bordered">
<tr>
<td rowspan="8">
<img src="<c:url value="/resources/images/${product.productId}.jpg" />"height="300"  alt="Generic Placeholder">
</td>

<tr>
<td>Product Id</td>
<td>${product.productId}</td>
</tr>

<tr>
<td>Product Name</td>
<td>${product.productName}</td>
</tr>

<tr>
<td>Price</td>
<td>${product.price}</td>
</tr>

<tr>
<td>Stock</td>
<td>${product.stock}</td>
</tr>

<tr>
<td>Category</td>
<td>${product.categoryId}</td>
</tr>

<tr>
<td>Supplier Id</td>
<td>${product.supplierId}</td>
</tr>

<tr>
<td>Description</td>
<td>${product.productDesc}</td>
</tr>

<tr>
<td>Quantity
<select name="quantity">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
</td>
<td><input type="submit" value="BUY" class="btn btn-success"></td>
</tr>

</table>
</form>
</div>
