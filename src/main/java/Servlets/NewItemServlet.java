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

/**
 * Servlet implementation class NewItemServlet
 */
public class NewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewItemServlet() {
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
		String name = request.getParameter("name");
		String iprice = request.getParameter("price");
		String istock = request.getParameter("stock");
		float price=Float.parseFloat(iprice); 
		int stock=Integer.parseInt(istock);
		
		ItemInfo itemInfoObj=new ItemInfo();
		itemInfoObj.setName(name);
		itemInfoObj.setPrice(price);
		itemInfoObj.setStock(stock);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/item-details-page";
		WebTarget webTarget = client.target(apiURL).path("create-item");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(itemInfoObj, MediaType.APPLICATION_JSON));
	
		ItemInfo validate = clientResponse.readEntity(ItemInfo.class);
		
		int itemid=validate.getItem_id();
    	out.println("Item id "+ itemid + " created");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
