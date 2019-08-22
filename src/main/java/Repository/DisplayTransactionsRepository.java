package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Transactions;

public class DisplayTransactionsRepository {
	
	
	public List<Transactions> checkTransactions(Transactions tranObj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WareHouse");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	Query query = em.createQuery("Select trans from Transactions trans where transaction_date='"+tranObj.getTransaction_date()+"'");
    	List<Transactions> list =(List<Transactions>)query.getResultList();
    	em.getTransaction().commit();
    	return list;
	}

}
