<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Check</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="CustomerInfoServlet">
<h3 style="color:blue">Customer Information Page</h3>
<p>Customer ID:<input type="text" name="custid" value=""></p>
<input type="submit" name="index_validate" value="submit">
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>

</body>
</html>