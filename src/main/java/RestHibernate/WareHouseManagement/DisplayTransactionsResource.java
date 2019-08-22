package RestHibernate.WareHouseManagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import Repository.DisplayTransactionsRepository;
import bean.Transactions;

public class DisplayTransactionsResource {
	
	@Context
	HttpServletRequest request;
	@Context
	HttpSession session;
	@POST
    @Path("filter")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Transactions> getTransactions(Transactions tranObj) throws IOException
    {
		DisplayTransactionsRepository repo=new DisplayTransactionsRepository();
		List<Transactions> list=repo.checkTransactions(tranObj);
		return list;
    	
    }


}
