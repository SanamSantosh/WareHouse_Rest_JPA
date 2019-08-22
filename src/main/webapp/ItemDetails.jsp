<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="ItemDetailsServlet">
<h3 style="color:blue">Items Page</h3>
<p>Please Choose from the following:</p>
<select name="option">
    <option value="ItemInfo" >Display Item Information</option>
    <option value="NewItem">Add New Item</option>
    <option value="AddStock">Add Stock</option>
  </select>
  <br><br>
  <input type="submit">
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>