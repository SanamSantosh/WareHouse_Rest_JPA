package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

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

import Repository.CustomerInfoRepository;
import Repository.ItemDetailsRepository;
import bean.CustomerInfo;
import bean.ItemInfo;
import bean.Transactions;

/**
 * Servlet implementation class BillingServlet
 */
public class BillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingServlet() {
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
		String cid = request.getParameter("cusid");
		String iid = request.getParameter("itemid");
		String quan = request.getParameter("quantity");
		int itemid=Integer.parseInt(iid);
		int custid=Integer.parseInt(cid);
		int quantity=Integer.parseInt(quan);
		HttpSession session=request.getSession();  
        session.setAttribute("item_id",iid);
		
		CustomerInfo custInfoObj = new CustomerInfo();
		custInfoObj.setCustomer_id(custid);
		CustomerInfoRepository repo=new CustomerInfoRepository();
		CustomerInfo custInfoObj1 = new CustomerInfo();
		custInfoObj1=repo.findCustomer(custInfoObj);
		
		if(custInfoObj1.getName()!=null)
		{
		ItemInfo itemInfoObj = new ItemInfo();
		itemInfoObj.setItem_id(itemid);
		ItemDetailsRepository repo1=new ItemDetailsRepository();
		ItemInfo itemInfoObj1 = new ItemInfo();
		itemInfoObj1=repo1.findItem(itemInfoObj);
		if(itemInfoObj1.getName()!=null)
		{
			
		LocalDate transactiondate=java.time.LocalDate.now();
		Date transaction_date=Date.valueOf(transactiondate);
		Transactions tranObj=new Transactions();
		tranObj.setCustObj(custInfoObj1);
		tranObj.setItemObj(itemInfoObj1);
		tranObj.setQuantity(quantity);
		tranObj.setTransaction_date(transaction_date);
		Client client = ClientBuilder.newClient( new ClientConfig() );
		String apiURL = "http://localhost:8081/WareHouseManagement/webapi/transactions-page";
		WebTarget webTarget = client.target(apiURL).path("inserting");
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response clientResponse = invocationBuilder.post(Entity.entity(tranObj, MediaType.APPLICATION_JSON));
		String validate = clientResponse.readEntity(String.class);
		out.println("<p>"+validate+"</p>");
		out.println("<p><a href=\"DisplayMerchantDetails.jsp\"><input type=\"button\" name=\"button\" value=\"PurchaseStock\"></a></p>");
		}
		else
			out.println("Item Id does not exist");
		}
		else
			out.println("Customer Id does not exist");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
