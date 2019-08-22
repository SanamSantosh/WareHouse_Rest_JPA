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

import bean.CustomerInfo;

/**
 * Servlet implementation class CreateCustomerServlet
 */
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerServlet() {
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
		String phonenumber = request.getParameter("phonenumber");
		String address = request.getParameter("address");
		int size=phonenumber.length();
		if(name!=null && address!=null && phonenumber!=null) {
		if(size==10) {
		CustomerInfo custInfoObj=new CustomerInfo();
		custInfoObj.setName(name);
		custInfoObj.setAdderss(address);
		custInfoObj.setPhonenumber(phonenumber);
		
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/customer-info-page";
		WebTarget webTarget = client.target(apiURL).path("create-customer");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response clientResponse = invocationBuilder.post(Entity.entity(custInfoObj, MediaType.APPLICATION_JSON));
	
		CustomerInfo validate = clientResponse.readEntity(CustomerInfo.class);
		
		int custid=validate.getCustomer_id();
    	out.println("Customer id "+ custid + " created");
		}
		else
			out.println("Phone number must be of size 10");
		}
		else
			out.println("Please do not leave any field blank");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doGet(request, response);
	}

}
