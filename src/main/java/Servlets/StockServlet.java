package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
 * Servlet implementation class StockServlet
 */
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
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
		String istock = request.getParameter("stock"); 
		int stock=Integer.parseInt(istock);
		HttpSession session=request.getSession();  
		String icode=(String) session.getAttribute("itmcode");
		int itemid=Integer.parseInt(icode);
		if(stock>0) {
		ItemInfo itemInfoObj=new ItemInfo();
		itemInfoObj.setItem_id(itemid);
		itemInfoObj.setStock(stock);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/item-details-page";
		WebTarget webTarget = client.target(apiURL).path("add-stock");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(itemInfoObj, MediaType.APPLICATION_JSON));
	
		ItemInfo validate = clientResponse.readEntity(ItemInfo.class);
		
		int s=validate.getStock();
    	out.println("Stock Changed to "+ s);
		}
		else
			out.println("<p style=\"color:red\">Stock should be positive value</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
