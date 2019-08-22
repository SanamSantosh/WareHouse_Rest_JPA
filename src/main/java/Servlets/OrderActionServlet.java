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

import bean.ItemInfo;
import bean.PurchaseDetails;

/**
 * Servlet implementation class OrderActionServlet
 */
public class OrderActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		String id=request.getParameter("purchaseid");
		int purchaseid=Integer.parseInt(id);
//		MerchantStock merchantStockObj=(MerchantStock) session.getAttribute("merchant_stock");
//		System.out.println(merchantStockObj);
		PurchaseDetails purchaseDetailsObj=new PurchaseDetails();;
		purchaseDetailsObj.setPurchase_id(purchaseid);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/purchase-details-page";
		WebTarget webTarget = client.target(apiURL).path("find-details");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(purchaseDetailsObj, MediaType.APPLICATION_JSON));
		PurchaseDetails purchaseObj = clientResponse.readEntity(PurchaseDetails.class);
		
		
		if (action.equals("accept")) {
		ItemInfo itemInfoObj=new ItemInfo();
		itemInfoObj.setItem_id(purchaseObj.getMerchantObj().getItemObj().getItem_id());
		itemInfoObj.setStock(purchaseObj.getQuantity());
		client = ClientBuilder.newClient( new ClientConfig() );
		apiURL = "http://localhost:8081/WareHouseManagement/webapi/item-details-page";
		webTarget = client.target(apiURL).path("add-stock");
		invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		clientResponse = invocationBuilder.post(Entity.entity(itemInfoObj, MediaType.APPLICATION_JSON));
	
		ItemInfo validate = clientResponse.readEntity(ItemInfo.class);
		
		int s=validate.getStock();
    	out.println("Item Info Stock increased to "+ s);
    	apiURL = "http://localhost:8081/WareHouseManagement/webapi/merchant-details-page";
    	webTarget = client.target(apiURL).path("reduce-stock");
    	invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
    	clientResponse = invocationBuilder.post(Entity.entity(purchaseObj, MediaType.APPLICATION_JSON));
    	PurchaseDetails result=clientResponse.readEntity(PurchaseDetails.class);
    	s=result.getMerchantObj().getStock();
    	out.println("Merchant Stock reduced to "+ s);
		}
		else if (action.equals("reject")) {
			client = ClientBuilder.newClient( new ClientConfig() );
			apiURL = "http://localhost:8081/WareHouseManagement/webapi/merchant-details-page";
			webTarget = client.target(apiURL).path("remove-purchase");
			invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
			clientResponse = invocationBuilder.post(Entity.entity(purchaseObj, MediaType.APPLICATION_JSON));
		
			String validate = clientResponse.readEntity(String.class);
			out.println(validate);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
