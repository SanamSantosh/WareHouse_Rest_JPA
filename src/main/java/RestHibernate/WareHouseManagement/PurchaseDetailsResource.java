package RestHibernate.WareHouseManagement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.PurchaseDetailsRepository;
import bean.PurchaseDetails;

@Path("purchase-details-page")
public class PurchaseDetailsResource {
	
	//this method is for calling repository inserting the order details into the order table
	//after a purchase order is made from the warehouse
	@POST
    @Path("insert-purchase")
    @Produces(MediaType.APPLICATION_JSON)
    public String purchase(PurchaseDetails purchaseObj)
    {
    	PurchaseDetailsRepository repo=new PurchaseDetailsRepository();
    	String reply=repo.insertPurchase(purchaseObj);
		return reply;
	
    }
	
	//this method is for calling repository for finding all the order details from the db
	// for a particular merchant
	@POST
    @Path("find-details")
    @Produces(MediaType.APPLICATION_JSON)
    public PurchaseDetails findDetails(PurchaseDetails purchaseObj)
    {
    	PurchaseDetailsRepository repo=new PurchaseDetailsRepository();
    	PurchaseDetails detailsObj=repo.findPurchase(purchaseObj);
		return detailsObj;
	
    }

}
