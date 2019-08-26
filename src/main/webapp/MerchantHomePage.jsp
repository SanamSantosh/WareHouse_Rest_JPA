<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant Home page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="MerchantHomeServlet">
<h3 style="color:blue">Home Page</h3>
<p>Please Choose from the following options:</p>
<select name="option">
    <option value="View" >View Orders</option>
    <option value="New">Add New Merchant</option>
  </select>
  <br><br>
  <input type="submit">
  <a href="MerchantLogin.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>