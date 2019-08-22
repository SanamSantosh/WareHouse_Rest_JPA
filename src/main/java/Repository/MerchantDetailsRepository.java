package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.MerchantStock;
import bean.PurchaseDetails;

public class MerchantDetailsRepository {
	
	public MerchantStock addMerchantStock(MerchantStock merchantStockObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(merchantStockObj);	
    	em.getTransaction().commit();
		return merchantStockObj;
	}
	


	public PurchaseDetails reduceStock(PurchaseDetails purchaseObj) {
		System.out.println(purchaseObj);
		MerchantStock merchantStockObj=new MerchantStock();
		PurchaseDetails detailsObj=new PurchaseDetails();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	merchantStockObj=em.find(MerchantStock.class, purchaseObj.getMerchantObj().getStock_id());
    	merchantStockObj.setStock(merchantStockObj.getStock()- purchaseObj.getQuantity());
    	em.persist(merchantStockObj);	
    	detailsObj.setMerchantObj(merchantStockObj);
//    	em.remove(purchaseObj);
    	em.getTransaction().commit();
		return detailsObj;
	}
	
	public String removePurchase(PurchaseDetails purchaseObj) {
		PurchaseDetails detailsObj=new PurchaseDetails();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	detailsObj=em.find(PurchaseDetails.class, purchaseObj.getPurchase_id());
    	em.remove(detailsObj);
    	em.getTransaction().commit();
		return "Yes";
	}

}
