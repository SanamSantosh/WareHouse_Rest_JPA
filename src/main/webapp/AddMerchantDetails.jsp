<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MerchantPage</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="AddMerchantDetailsServlet">
<h3 style="color:blue">Add Merchant Stock Details</h3>
<table border="1" align="center" >
<tr><td>Stock Id:</td><td><input type="text" name="stockid" value=""></td></tr>
<tr><td>Item Id:</td><td><input type="text" name="itemid" value=""></td></tr>
<tr><td>Merchant Id:</td><td><input type="text" name="merchantid" value=""></td></tr>
<tr><td>Price:</td><td><input type="text" name="price" value=""></td></tr>
<tr><td>Stock:</td><td><input type="text" name="stock" value=""></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="MerchantHomePage.jsp"><input type="button" name="button" value="back"></a>
<a href="Login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>