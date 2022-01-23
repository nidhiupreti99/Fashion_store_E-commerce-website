<%@page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>


<div class="container">
<form action="<c:url value="/reciept"/>" method="post">
<table class="table table-bordered" width="50%" align="center">


<tr class="success">
<td colspan="2"></td><center>Payment Detail</center>
</tr>

<tr class="info">
<td colspan="2">
<center>
<input type="radio" name="rd" value="cc">Credit Card
<input type="radio" name="rd" value="cod">Cash On delivery
</center>
</td>
</tr>


<tr class="warning">
<td>Card Number</td>
<td><input type="text" name="cardno"></td>
</tr>

<tr class="warning">
<td>Valid<input type="text" name="Valid"></td>
<td>CVV<input type="text" name="CVV"></td>
</tr>

<tr class="warning">
<td><input type="text" name="name"/></td>
</tr>

<tr class="success">
<td colspan="2"><center><input type="submit" value="Pay" class="tn btn-success"/></center></td>
</tr>

</table>
</form>
</div>
