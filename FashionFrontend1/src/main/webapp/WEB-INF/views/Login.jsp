<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>

<form action="perform_login"  method="post">
<table border="1" align = "center">
<tr bg color="gray">
<td colspan ="2"><center>Sign in</center></td>
</tr>
<tr bgcolor="pink">
<td>Username</td>
<td><input type="text" name="username"required/></td>
</tr>

<tr bgcolor="pink">
<td>Password</td>
<td><input type="password" name="password" required/></td>
</tr>
<tr bgcolor="gray">
<td colspan="2"><center><input type="submit" value="LOGIN" class="btn btn-danger"/></center>
</td>
</tr>




</table>

</form>