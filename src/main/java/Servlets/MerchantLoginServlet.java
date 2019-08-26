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

import bean.MerchantDetails;

/**
 * Servlet implementation class MerchantLoginServlet
 */
public class MerchantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantLoginServlet() {
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
		//reading the user provided details
		String merchant = request.getParameter("merchantid");
		String password = request.getParameter("password");
		//converting into required data type
		int merchantid=Integer.parseInt(merchant);
		HttpSession session=request.getSession();
		session.setAttribute("merchant_id", merchantid);
		
		MerchantDetails merchantObj = new MerchantDetails();
		merchantObj.setMerchant_id(merchantid);
		merchantObj.setPassword(password);
		//passes the merchant object to resource file to check the merchant login details
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/merchant-login-page";
		WebTarget webTarget = client.target(apiURL).path("validation");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(merchantObj, MediaType.APPLICATION_JSON));
		String validate = clientResponse.readEntity(String.class);
		if(validate.equals("Yes")) 
			response.sendRedirect("MerchantHomePage.jsp");
		else
			out.println("Invalid Credentials");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
