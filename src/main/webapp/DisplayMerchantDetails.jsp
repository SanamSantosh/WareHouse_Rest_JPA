<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.MerchantDetails" import="Repository.MerchantDetailsRepository"
    import="bean.MerchantStock" import="javax.persistence.EntityManager" import="javax.persistence.EntityManagerFactory"
    import="javax.persistence.Persistence" import="javax.persistence.Query" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head >

<meta charset="UTF-8">
<title>Merchant Details</title>
</head>


<body style="text-align:center">
<h3 style="color:blue">Merchant Details</h3>
<%

String id=(String)session.getAttribute("item_id");

Query query;
EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
EntityManager em = emf.createEntityManager();
if (id!=null){
int itemid=Integer.parseInt(id);
query = em.createQuery("Select merchantStock from MerchantStock merchantStock where itemObj_item_id="+itemid);
}
else{
query = em.createQuery("Select merchantStock from MerchantStock merchantStock ");
}
List<MerchantStock> list =(List<MerchantStock>)query.getResultList();
%>
<div style="overflow: auto;height: 180px;">
<table border="1" align="center">
<tr><td>Stock Id</td><td>Item Id</td><td>Item Name</td><td>Merchant Id</td><td>Merchant Name</td><td>Price</td><td>Stock</td></tr>

<% System.out.println("printing");
for(MerchantStock merchantStock:list){ %>

<tr><td><input type="text" value=<%=merchantStock.getStock_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getItem_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getMerchant_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getPrice()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getStock()%> readonly></td></tr>

<% }%>

</table>
</div> 

<br><br>
<%@include file="PurchaseStock.jsp" %>
</body>
</html>