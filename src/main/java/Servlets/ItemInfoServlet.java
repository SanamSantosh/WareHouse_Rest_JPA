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
 * Servlet implementation class ItemInfoServlet
 */
public class ItemInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
		String iid = request.getParameter("itemid"); 
		int itemid=Integer.parseInt(iid);  
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();  
        session.setAttribute("itemid",iid); 
		
		ItemInfo itemInfoObj = new ItemInfo();
		itemInfoObj.setItem_id(itemid);
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/item-details-page";
		WebTarget webTarget = client.target(apiURL).path("check-item");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(itemInfoObj, MediaType.APPLICATION_JSON));
		String validate = clientResponse.readEntity(String.class);
		if(validate.equals("Yes")) {
			response.sendRedirect("ItemInfo.jsp");
		}
		else {
			out.println("Item does not exist");
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
