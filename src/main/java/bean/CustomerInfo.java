package bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id;
	private String name,phonenumber,adderss;
	public CustomerInfo(int t_customer_id,String t_name,String t_phonenumber,String t_address) {
		super();  
	    this.customer_id = t_customer_id;  
	    this.name = t_name;
	    this.phonenumber=t_phonenumber;
	    this.adderss=t_address;
	}
	public CustomerInfo() {
		super();
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	@Override
	public String toString() {
		return "CustomerInfo [customer_id=" + customer_id + ", name=" + name + ", phonenumber=" + phonenumber
				+ ", adderss=" + adderss + "]";
	}
	
	
}
