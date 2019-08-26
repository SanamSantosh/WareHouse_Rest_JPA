package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Transactions;

public class DisplayTransactionsRepository {
	
	//This method checks for the transactions with a given date and 
	//returns the list of transactions for the given date
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
