<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Item Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="ItemInfoServlet">
<h3 style="color:blue">Item Information Page</h3>
<p>Item ID:<input type="text" name="itemid" value=""></p>
<input type="submit" name="index_validate" value="submit">
<a href="ItemDetails.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>