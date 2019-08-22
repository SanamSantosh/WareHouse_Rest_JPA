package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import bean.MerchantStock;
import bean.PurchaseDetails;

public class PurchaseDetailsRepository {
	
	public String insertPurchase(PurchaseDetails purchaseObj) {
		MerchantStock merchantObj=new MerchantStock();
		PurchaseDetails purchase=new PurchaseDetails();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	merchantObj=em.find(MerchantStock.class, purchaseObj.getMerchantObj().getStock_id());
    	purchase.setMerchant_id(purchaseObj.getMerchant_id());
    	purchase.setMerchantObj(merchantObj);
    	purchase.setPurchase_id(purchaseObj.getPurchase_id());
    	purchase.setQuantity(purchaseObj.getQuantity());
    	em.persist(purchase);	
    	em.getTransaction().commit();
    	String reply;
    	if(merchantObj!=null) {
        reply="Order placed \n PurchaseId= "+purchase.getPurchase_id();
		return reply;
    	}
    	else {
    		reply="Couldnt place order";
    		return reply;	
    	}
	}
	
	public PurchaseDetails findPurchase(PurchaseDetails purchaseObj) {
		PurchaseDetails purchace=new PurchaseDetails();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	purchace=em.find(PurchaseDetails.class,purchaseObj.getPurchase_id());
    	em.getTransaction().commit();
		return purchace;
	}

}
