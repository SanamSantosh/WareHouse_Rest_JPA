package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.MerchantStock;
import bean.PurchaseDetails;

public class MerchantDetailsRepository {
	
	//This method adds the merchant details in the database
	public MerchantStock addMerchantStock(MerchantStock merchantStockObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(merchantStockObj);	
    	em.getTransaction().commit();
		return merchantStockObj;
	}
	

	//This method updates the stock value in the database
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
	
	
	//this method removes the purchase details from the database with respect to purchaseid
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
