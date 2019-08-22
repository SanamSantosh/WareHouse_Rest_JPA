package Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bean.ItemInfo;

public class ItemDetailsRepository {
	
	public ItemInfo addItem(ItemInfo itemInfoObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(itemInfoObj);	
    	em.getTransaction().commit();
		return itemInfoObj;
	}
	
	public ItemInfo findItem(ItemInfo itemInfoObj) {
		ItemInfo itemObj=new ItemInfo();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	itemObj=em.find(ItemInfo.class, itemInfoObj.getItem_id());    	
    	em.getTransaction().commit();
    	return itemObj;
	}
	
	public ItemInfo addStock(ItemInfo itemInfoObj) {
		ItemInfo itemObj=new ItemInfo();
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	itemObj=em.find(ItemInfo.class, itemInfoObj.getItem_id());
    	itemObj.setStock(itemInfoObj.getStock()+itemObj.getStock());
    	em.persist(itemObj);	
    	em.getTransaction().commit();
		return itemObj;
	}

}
