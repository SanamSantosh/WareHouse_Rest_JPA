package RestHibernate.WareHouseManagement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.MerchantLoginRepository;
import bean.MerchantDetails;

@Path("merchant-login-page")
public class MerchantLoginResource {
	
	//this method is for calling repository for getting merchant login information
	//for the entered merchant id
	@POST
    @Path("validation")
    @Produces(MediaType.TEXT_PLAIN)
    public String Details(MerchantDetails merchantObj)
    {
    	MerchantLoginRepository repo=new MerchantLoginRepository();
    	MerchantDetails merchantObj1=repo.getDetails(merchantObj);
    	if (merchantObj1.getMerchant_id()==merchantObj.getMerchant_id() && merchantObj1.getPassword().equals(merchantObj.getPassword()))
		    return "Yes";
    	else
    		return "No";
    	
    }

}
