package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("");
		String option = request.getParameter("option");
		switch(option) {
		case "CustInfo":
			response.sendRedirect("CustomerCheck.jsp");
			break;
		case "ItemDetails":
			response.sendRedirect("ItemDetails.jsp");
			break;
		case "Bill":
			response.sendRedirect("Billing.jsp");
			break;
		case "Cancel":
			response.sendRedirect("CancelOrder.jsp");
			break;
		case "Tran":
			response.sendRedirect("DisplayTransactions.jsp");
			break;
		case "Purchase":
			response.sendRedirect("DisplayMerchantDetails.jsp");
			break;
		default:
			response.sendRedirect("Home.jsp");
			break;
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
