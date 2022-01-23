<%@page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/Header.jsp"%>

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
