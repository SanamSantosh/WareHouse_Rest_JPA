<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Transaction</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="CancelTransactionServlet">
<h3 style="color:blue">Check Transaction</h3>
<table border="1" align="center" >
<tr><td>Transaction Id:</td><td><input type="text" name="tranid" value=""></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="Login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>