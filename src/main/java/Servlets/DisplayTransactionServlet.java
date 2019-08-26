package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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

import bean.Transactions;

/**
 * Servlet implementation class DisplayTransactionServlet
 */
public class DisplayTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTransactionServlet() {
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
		String tdate = request.getParameter("trandate"); 
		//converting to required data type
		Date trandate=Date.valueOf(tdate);
//		int itemid=Integer.parseInt(iid);  
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(); 
		
		Transactions tranObj = new Transactions();
		tranObj.setTransaction_date(trandate); 
        session.setAttribute("tranObj",tranObj); 
        //passing the transaction object to resource file
        //prints the transaction details of any transactions present in the given date 
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/transactions-page";
		WebTarget webTarget = client.target(apiURL).path("filter");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(tranObj, MediaType.APPLICATION_JSON));
		String validate = clientResponse.readEntity(String.class);
		if(validate.equals("Yes")) {
			System.out.println(validate);
			response.sendRedirect("ViewTransactions.jsp");
		}
		else {
			out.println("Transactions not available at given date");
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
