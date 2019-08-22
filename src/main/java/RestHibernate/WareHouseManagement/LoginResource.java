package RestHibernate.WareHouseManagement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Repository.LoginRepository;
import bean.Login;

@Path("login-page")
public class LoginResource {
	
	@POST
    @Path("validation")
    @Produces(MediaType.TEXT_PLAIN)
    public String Details(Login login)
    {
    	LoginRepository repo=new LoginRepository();
    	Login loginobj=repo.getDetails(login);
    	if (loginobj.getLogin_id().equals(login.getLogin_id()) && loginobj.getPassword().equals(login.getPassword()))
		    return "Yes";
    	else
    		return "No";
    	
    }

}
