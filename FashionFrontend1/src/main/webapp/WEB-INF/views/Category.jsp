<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="AddCategory" method="post">
	<table align="center" class="table">
		<tr>
			<td colspan="2">
				<center>
					<h3>Category</h3>
				</center>
			</td>
		</tr>

		<tr>
			<td>Category Name</td>
			<td><input type="text" name="catgName"></td>
		</tr>

		<tr>
			<td>Category Description</td>
			<td><input type="text" name="catgDesc" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<center>
					<input type="submit" value="Add Category" />
				</center>
			</td>
		</tr>
	</table>
</form>
<table class="table-bordered">
<tr>
<td>Category Id</td>
<td>Category Name</td>
<td>Category Description</td>
<td>Operation</td>
<c:forEach items ="${listCategories}" var="category">
<tr>
<td>${category.categoryId}</td>
<td>${category.categoryName}</td>
<td>${category.categoryDesc}</td>

<td> <a href="<c:url value="/editCategory/${category.categoryId}"/>" class="btn btn-success">EDIT</a> </td>
<td> <a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger">DANGER</a> </td>


</tr>
</c:forEach>

</table>
