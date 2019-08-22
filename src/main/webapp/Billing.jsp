<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="BillingServlet">
<h3 style="color:blue">Billing</h3>
<table border="1" align="center">
<tr><td>Customer Id:</td><td><input type="text" name="cusid" value=""></td></tr>
<tr><td>Item Id:</td><td><input type="text" name="itemid" value=""></td></tr>
<tr><td>Quantity:</td><td><input type="text" name="quantity" value=""></td></tr>
<tr><td><input type="reset" name="index_clear" value="Clear"></td>
<td><input type="submit" name="index_validate" value="submit"></td></tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="Login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>