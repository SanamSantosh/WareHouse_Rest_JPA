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
import bean.MerchantDetails;
import bean.MerchantStock;

/**
 * Servlet implementation class AddMerchantDetailsServlet
 */
public class AddMerchantDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMerchantDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
		PrintWriter out=response.getWriter();
		String mstockid = request.getParameter("stockid");
		String mitemid = request.getParameter("itemid");
		String merchant = request.getParameter("merchantid");
		String mprice = request.getParameter("price");
		String mstock = request.getParameter("stock");
		float price=Float.parseFloat(mprice); 
		int stock=Integer.parseInt(mstock);
		int merchantid=Integer.parseInt(merchant);
		int stockid=Integer.parseInt(mstockid);
		int itemid=Integer.parseInt(mitemid);
		
		MerchantStock merchantStockObj=new MerchantStock();
		MerchantDetails merchantObj=new MerchantDetails();
		ItemInfo itemObj=new ItemInfo();
		itemObj.setItem_id(itemid);
		merchantObj.setMerchant_id(merchantid);
		merchantStockObj.setStock_id(stockid);
		merchantStockObj.setItemObj(itemObj);
		merchantStockObj.setMerchantObj(merchantObj);
		merchantStockObj.setPrice(price);
		merchantStockObj.setStock(stock);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/merchant-details-page";
		WebTarget webTarget = client.target(apiURL).path("create-merchant-stock");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(merchantStockObj, MediaType.APPLICATION_JSON));
	
		MerchantStock validate = clientResponse.readEntity(MerchantStock.class);
		
		int mstock_id=validate.getStock_id();
    	out.println("Merchant stock "+ mstock_id + " created");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
