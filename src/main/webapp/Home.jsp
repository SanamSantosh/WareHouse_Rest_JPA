<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="HomeServlet">
<h3 style="color:blue">Home Page</h3>
<p>Please Choose from the following options:</p>
<select name="option">
    <option value="CustInfo" >Display Customer Information</option>
    <option value="ItemDetails">Display Item Information</option>
    <option value="Bill">Billing</option>
    <option value="Cancel">Cancel Order</option>
    <option value="Tran">Transactions</option>
    <option value="Purchase">Purchase Stock</option>
  </select>
  <br><br>
  <input type="submit">
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>