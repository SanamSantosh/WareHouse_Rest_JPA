<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.ws.rs.client.Entity" import="javax.ws.rs.client.Invocation"
    import="javax.ws.rs.client.WebTarget" import="javax.ws.rs.core.MediaType" import="bean.Transactions"
    import="java.util.List" import="javax.ws.rs.client.Client" import="javax.ws.rs.client.ClientBuilder"
    import="javax.ws.rs.core.Response" import="org.glassfish.jersey.client.ClientConfig"
    import="RestHibernate.WareHouseManagement.DisplayTransactionsResource"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions Page</title>
</head>
<body align="center">

  <%@include file="DisplayTransactions.jsp" %>
<h1 style="color:blue">Item Details</h1>
        	<%
        	Transactions tranObj=(Transactions)session.getAttribute("tranObj");
        	DisplayTransactionsResource repo=new DisplayTransactionsResource();
        	
    		List<Transactions> list = repo.getTransactions(tranObj);
        	%>
        	<table border="1" align="center">
        	<tr><td>Transaction Id</td><td>Quantity</td><td>Date</td><td>Customer Id</td><td>Item Id</td></tr>
        	<% System.out.println("printing");
        	for(Transactions trans:list){ %>
        	
        	<tr><td><input type="text" value=<%=trans.getTransaction_id()%> readonly></td>
        	<td><input type="text" value=<%=trans.getQuantity()%> readonly></td>
        	<td><input type="text" value=<%=trans.getTransaction_date()%> readonly></td>
        	<td><input type="text" value=<%=trans.getCustObj().getCustomer_id()%> readonly></td>
        	<td><input type="text" value=<%=trans.getItemObj().getItem_id()%> readonly></td></tr>
        	
        	<% }%>
        	</table>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>