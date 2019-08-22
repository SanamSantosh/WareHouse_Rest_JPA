<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.CustomerInfo" import="Repository.CustomerInfoRepository"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Information</title>
</head>
<body align="center">

  <%@include file="CustomerCheck.jsp" %>
<h1 style="color:blue">Account Details</h1>
        	<%
        	CustomerInfoRepository repo = new CustomerInfoRepository();
        	CustomerInfo log1=new CustomerInfo();
        	String id=(String)session.getAttribute("custid");
        	int custid=Integer.parseInt(id);
        	log1.setCustomer_id(custid);
        	CustomerInfo log=repo.findCustomer(log1);%>
        	<table border="1" align="center">
        	<tr><td>Customer Name:</td><td><input type="text" value=<%=log.getName()%> readonly></td></tr>
        	<tr><td>Phone Number:</td><td><input type="text" value=<%=log.getPhonenumber()%> readonly></td></tr>
        	<tr><td>Address:</td><td><input type="text" value=<%=log.getAdderss()%> readonly></td></tr>
        	</table>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>