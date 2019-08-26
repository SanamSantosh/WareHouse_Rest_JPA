<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.MerchantDetails" import="Repository.MerchantDetailsRepository"
    import="bean.MerchantStock" import="javax.persistence.EntityManager" import="javax.persistence.EntityManagerFactory"
    import="javax.persistence.Persistence" import="javax.persistence.Query" import="java.util.List"
    import="bean.PurchaseDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body style="text-align:center">
<h3 style="color:blue">Order Details</h3>
<%

int merchantid=(int)session.getAttribute("merchant_id");

Query query;
int count;
String Accept="accept";
String Reject="reject";
EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
EntityManager em = emf.createEntityManager();
query = em.createQuery("Select purchase from PurchaseDetails purchase where merchant_id="+merchantid);
List<PurchaseDetails> list1 =(List<PurchaseDetails>)query.getResultList();

%>
<div style="overflow: auto;height: 180px;">
<table border="1" align="center">
<tr><td>Stock Id</td><td>Item Id</td><td>Item Name</td><td>Merchant Id</td><td>Merchant Name</td><td>Price</td><td>Stock</td></tr>

<% System.out.println("printing");
if(list1!=null){
for(PurchaseDetails details:list1){ 
query = em.createQuery("Select stock from MerchantStock stock where stock_id="+details.getMerchantObj().getStock_id());

List<MerchantStock> list =(List<MerchantStock>)query.getResultList();
for(MerchantStock merchantStock:list){ 
session.setAttribute("purchase_details",details);%>

<tr><td><input type="text" value=<%=merchantStock.getStock_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getItem_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getMerchant_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getPrice()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getStock()%> readonly></td>
<td><a href="OrderActionServlet?action=<%=Accept%>&purchaseid=<%=details.getPurchase_id()%>"><input type="button" name="name" value="Accept"></a></td>
<td><a href="OrderActionServlet?action=<%=Reject%>&purchaseid=<%=details.getPurchase_id()%>"><input type="button" name="name" value="Reject"></a></td></tr>

<% }}}
else{
out.println("<h3>No Orders</h3>");
System.out.println("no orders");} %>

</table>
</div> 
<a href="MerchantLogin.jsp"><input type="button" name="button" value="Logout"></a>
<a href="MerchantHomePage.jsp"><input type="button" name="button" value="Back"></a>

<br><br>
</body>
</html>