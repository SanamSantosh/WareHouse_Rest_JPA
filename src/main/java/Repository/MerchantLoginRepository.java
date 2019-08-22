package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.MerchantDetails;

public class MerchantLoginRepository {
	
	public MerchantDetails getDetails(MerchantDetails merchnat) {
		MerchantDetails merchantObj=new MerchantDetails();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	System.out.println(merchnat);
    	em.getTransaction().begin();
    	merchantObj=em.find(MerchantDetails.class, merchnat.getMerchant_id());    	
    	em.getTransaction().commit();
    	System.out.println(merchantObj);
		return merchantObj;
	}

}
