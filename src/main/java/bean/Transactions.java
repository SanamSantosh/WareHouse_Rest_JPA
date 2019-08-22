package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	@ManyToOne
	private CustomerInfo custObj;
	@ManyToOne
	private ItemInfo itemObj;
	private Date transaction_date;
	private int quantity;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public CustomerInfo getCustObj() {
		return custObj;
	}
	public void setCustObj(CustomerInfo custObj) {
		this.custObj = custObj;
	}
	public ItemInfo getItemObj() {
		return itemObj;
	}
	public void setItemObj(ItemInfo itemObj) {
		this.itemObj = itemObj;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", custObj=" + custObj + ", itemObj=" + itemObj
				+ ", transaction_date=" + transaction_date + ", quantity=" + quantity + "]";
	}
	
	
	
}
