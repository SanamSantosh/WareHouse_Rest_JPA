package RestHibernate.WareHouseManagement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.CustomerInfoRepository;
import bean.CustomerInfo;

@Path("customer-info-page")
public class CustomerInfoResource {
	
	
	
	@POST
    @Path("check-customer")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkCustomer(CustomerInfo custInfoObj)
    {
		CustomerInfoRepository repo=new CustomerInfoRepository();
		CustomerInfo custObj=repo.findCustomer(custInfoObj);
    	if(custObj!=null)
		return "Yes";
    	else
    		return "No";
    	
    }
	
	@POST
    @Path("create-customer")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerInfo createCustomer(CustomerInfo custInfoObj)
    {
		CustomerInfoRepository repo=new CustomerInfoRepository();
		CustomerInfo custObj=repo.addCustomer(custInfoObj);
		return custObj;
	
    }
	


}
