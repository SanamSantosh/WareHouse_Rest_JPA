package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import bean.MerchantStock;
import bean.PurchaseDetails;

/**
 * Servlet implementation class PurchaseStockServlet
 */
public class PurchaseStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String stock = request.getParameter("stockid");
		String merchant = request.getParameter("merchantid");
		String quan = request.getParameter("quantity");
		int stockid=Integer.parseInt(stock);
		int merchantid=Integer.parseInt(merchant);
		int quantity=Integer.parseInt(quan);
		if(quantity>0) {
		MerchantStock merchantObj=new MerchantStock();
		merchantObj.setStock_id(stockid);
		PurchaseDetails purchaseObj=new PurchaseDetails();
		purchaseObj.setQuantity(quantity);
		purchaseObj.setMerchantObj(merchantObj);
		purchaseObj.setMerchant_id(merchantid);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/purchase-details-page";
		WebTarget webTarget = client.target(apiURL).path("insert-purchase");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(purchaseObj, MediaType.APPLICATION_JSON));
	
		String Reply = clientResponse.readEntity(String.class);
		
    	out.println(Reply);
		}
		else
			out.println("<p style=\"color:red\">Quantity must be positive value</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
