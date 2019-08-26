package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.ItemInfo;
import bean.Transactions;

public class TransactionRepository {
	
	//This method inserts transaction details into database
	public String insertTransaction(Transactions tranObj) {
		ItemInfo itemObj=new ItemInfo();
		ItemInfo itemObj1=new ItemInfo();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	itemObj=tranObj.getItemObj();
    	itemObj1=em.find(ItemInfo.class, itemObj.getItem_id());
    	if(itemObj.getStock() > tranObj.getQuantity() && itemObj.getStock() - tranObj.getQuantity() > 0) {
        em.getTransaction().begin();
    	em.persist(tranObj);
    	int stock=itemObj1.getStock() - tranObj.getQuantity();
    	itemObj1.setStock(stock);
    	em.getTransaction().commit();
    	String reply="Transaction id "+tranObj.getTransaction_id()+" Successfull \n Total Amount = " + itemObj.getPrice()*tranObj.getQuantity();
    	return reply;
    	}
    	else {
    		String reply="Transaction failed due to insufficient stock \n Available Stock: "+itemObj.getStock();
		return reply;
    	}
	}
	
	//This method delets the given transaction from the database
	public String removeTransaction(Transactions tranObj) {
		ItemInfo itemObj=new ItemInfo();
		Transactions tranObj1=new Transactions();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	System.out.println(tranObj);
    	em.getTransaction().begin();
    	tranObj1=em.find(Transactions.class, tranObj.getTransaction_id());
    	
    	if (tranObj1!=null) {
    		itemObj=em.find(ItemInfo.class, tranObj1.getItemObj().getItem_id());
        	int stock=itemObj.getStock() + tranObj1.getQuantity();
        	itemObj.setStock(stock);
    		em.remove(tranObj1);
    		em.getTransaction().commit();
    		String reply="Transaction deleted successfully with id: "+tranObj1.getTransaction_id()+" \n Refund Amount=" +tranObj1.getQuantity()*tranObj1.getItemObj().getPrice();
    		return reply;
    	}
    	else{
    		em.getTransaction().commit();
    		String reply="Transaction does not Exist";
		return reply;
    	}
	}
	
	//this methods checks if the transactions exist or not on a given date
	public String checkTransactions(Transactions tranObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	Query query = em.createQuery("Select trans from Transactions trans where transaction_date='"+tranObj.getTransaction_date()+"'");
    	List<Transactions> list =(List<Transactions>)query.getResultList();
    	em.getTransaction().commit();
    	if(list!=null) {
    	return "Yes";
    	}
    	else {	
		return "No";
    	}
	}

}
