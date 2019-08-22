package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.Login;

public class LoginRepository {
	
	public Login getDetails(Login login) {
		Login loginobj=new Login();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	System.out.println(login);
    	em.getTransaction().begin();
    	loginobj=em.find(Login.class, login.getLogin_id());    	
    	em.getTransaction().commit();
    	System.out.println(loginobj);
		return loginobj;
	}

}
