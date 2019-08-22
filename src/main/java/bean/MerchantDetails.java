package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MerchantDetails {
	@Id
	private int merchant_id;
	private String name;
	private String password;
	public MerchantDetails(int m_merchant_id,String m_name,String m_password) {
		super();  
	    this.merchant_id = m_merchant_id;  
	    this.name = m_name;
	    this.password=m_password;
	}
	public MerchantDetails() {
		super();
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MerchantDetails [merchant_id=" + merchant_id + ", name=" + name + ", password=" + password + "]";
	}
	

}
