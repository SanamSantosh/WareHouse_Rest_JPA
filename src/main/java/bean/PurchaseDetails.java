package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchase_id;
	@ManyToOne
	private MerchantStock merchantObj;
	private int merchant_id;
	private int quantity;
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public MerchantStock getMerchantObj() {
		return merchantObj;
	}
	public void setMerchantObj(MerchantStock merchantObj) {
		this.merchantObj = merchantObj;
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
