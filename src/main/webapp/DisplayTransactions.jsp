<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions Page</title>
</head>
<body>
<form name="index" style="text-align:center" method="post" action="DisplayTransactionServlet">
<h3 style="color:blue">Transactions Page</h3>
<p>Transaction Date:<input type="date" name="trandate" value=""></p>
<input type="submit" name="index_validate" value="submit">
<a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>