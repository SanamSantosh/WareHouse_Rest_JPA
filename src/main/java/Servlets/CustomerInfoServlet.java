package Servlets;

import java.io.IOException;

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

import bean.CustomerInfo;

/**
 * Servlet implementation class CustomerInfoServlet
 */
public class CustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
		//reading the user provided details
		String cid = request.getParameter("custid"); 
		//converting to required data type
		int custid=Integer.parseInt(cid);  
		HttpSession session=request.getSession();  
        session.setAttribute("custid",cid); 
		
		CustomerInfo log = new CustomerInfo();
		log.setCustomer_id(custid);
		//passing the customer object to the resource file for checking if the customer exists or not
		// if exists displays the customer information
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/customer-info-page";
		WebTarget webTarget = client.target(apiURL).path("check-customer");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(log, MediaType.APPLICATION_JSON));
		String validate = clientResponse.readEntity(String.class);
		System.out.println("--------> " + validate);
		if(validate.equals("Yes")) {
			response.sendRedirect("CustomerInfo.jsp");
		}
		else {
			response.sendRedirect("CreateCustomer.jsp");
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
