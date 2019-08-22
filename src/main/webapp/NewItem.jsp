<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="NewItemServlet">
<h3 style="color:blue">Create a new Item</h3>
<table border="1" align="center" >
<tr><td>Item Name:</td><td><input type="text" name="name" value=""></td></tr>
<tr><td>Price:</td><td><input type="text" name="price" value=""></td></tr>
<tr><td>Stock:</td><td><input type="text" name="stock" value=""></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="ItemDetails.jsp"><input type="button" name="button" value="back"></a>
<a href="Login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>