package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.CustomerInfo;

public class CustomerInfoRepository {
	
	public CustomerInfo findCustomer(CustomerInfo custInfoObj) {
		CustomerInfo custObj=new CustomerInfo();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	custObj=em.find(CustomerInfo.class, custInfoObj.getCustomer_id());    	
    	em.getTransaction().commit();
    	return custObj;
	}
	
	public CustomerInfo addCustomer(CustomerInfo custInfoObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(custInfoObj);	
    	em.getTransaction().commit();
		return custInfoObj;
	}
	

}
