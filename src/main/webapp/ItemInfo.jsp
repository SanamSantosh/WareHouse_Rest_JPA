<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.ItemInfo" import="Repository.ItemDetailsRepository"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Info Page</title>
</head>
<body align="center">

  <%@include file="CheckItem.jsp" %>
<h1 style="color:blue">Item Details</h1>
        	<%
        	ItemDetailsRepository repo = new ItemDetailsRepository();
        	ItemInfo itemInfoObj=new ItemInfo();
        	String id=(String)session.getAttribute("itemid");
        	int itemid=Integer.parseInt(id);
        	itemInfoObj.setItem_id(itemid);
        	ItemInfo itemInfoObj1=repo.findItem(itemInfoObj);%>
        	<table border="1" align="center">
        	<tr><td>Item Name:</td><td><input type="text" value=<%=itemInfoObj1.getName()%> readonly></td></tr>
        	<tr><td>Price:</td><td><input type="text" value=<%=itemInfoObj1.getPrice()%> readonly></td></tr>
        	<tr><td>Stock:</td><td><input type="text" value=<%=itemInfoObj1.getStock()%> readonly></td></tr>
        	</table>
  <br><br>
  <a href="ItemDetails.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>