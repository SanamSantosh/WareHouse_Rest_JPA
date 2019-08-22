<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Creation</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="CreateCustomerServlet">
<h3 style="color:red">Customer does not exist. Create a new Customer</h3>
<table border="1" align="center" >
<tr><td>Customer Name:</td><td><input type="text" name="name" value=""></td></tr>
<tr><td>Customer Phone Number:</td><td><input type="text" name="phonenumber" value=""></td></tr>
<tr><td>Customer Address:</td><td><input type="text" name="address" value=""></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="Login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>