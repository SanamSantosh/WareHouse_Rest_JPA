package RestHibernate.WareHouseManagement;

import java.io.IOException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.TransactionRepository;
import bean.Transactions;

@Path("transactions-page")
public class TransactionsResource {
	
	//this method is for calling repository for inserting the transaction details after the billing
	@POST
    @Path("inserting")
    @Produces(MediaType.TEXT_PLAIN)
    public String transaction(Transactions tranObj)
    {
		TransactionRepository repo=new TransactionRepository();
		String reply=repo.insertTransaction(tranObj);
		return reply;
    }
	
	//this method is for calling repository for removing the transaction when order has been cancelled
	@POST
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTransaction(Transactions tranObj)
    {
		TransactionRepository repo=new TransactionRepository();
		String reply=repo.removeTransaction(tranObj);
		return reply;
    		
    }
	
	 
	//this method is for calling repository for getting the list of transactions for a particular date
	@POST
    @Path("filter")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTransactions(Transactions tranObj) throws IOException
    {
		TransactionRepository repo=new TransactionRepository();
		String reply=repo.checkTransactions(tranObj);
		return reply;
    	
    }


}
