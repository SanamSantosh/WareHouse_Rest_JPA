package RestHibernate.WareHouseManagement;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.ItemDetailsRepository;
import bean.ItemInfo;

@Path("item-details-page")
public class ItemDetailsResource {
	
	//this method is for calling repository for creating a new item in the db
	@POST
    @Path("create-item")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemInfo createItem(ItemInfo itemInfoObj)
    {
    	ItemDetailsRepository repo=new ItemDetailsRepository();
    	ItemInfo itemObj=repo.addItem(itemInfoObj);
		return itemObj;
	
    }
	
	//this method is for calling repository for checking for an item id in db
	@POST
    @Path("check-item")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkItem(ItemInfo itemInfoObj)
    {
		ItemDetailsRepository repo=new ItemDetailsRepository();
    	ItemInfo itemObj=repo.findItem(itemInfoObj);
    	if(itemObj!=null)
		return "Yes";
    	else
    		return "No";
    	
    }
	
	//this method is for calling repository is for adding stock for existing item in db
	@POST
    @Path("add-stock")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemInfo Stock(ItemInfo itemInfoObj)
    {
		ItemDetailsRepository repo=new ItemDetailsRepository();
    	ItemInfo itemObj=repo.addStock(itemInfoObj);
		return itemObj;
    	
    }


}
