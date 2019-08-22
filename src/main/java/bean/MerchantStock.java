package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MerchantStock {
	@Id
	private int stock_id;
	@ManyToOne
	private ItemInfo itemObj;
	@ManyToOne
	private MerchantDetails merchantObj;
	private float price;
	private int stock;
	public MerchantStock(int m_stock_id,ItemInfo m_itemObj,MerchantDetails m_merchantObj,float t_price,int t_stock) {
		super();  
	    this.stock_id = m_stock_id;  
	    this.itemObj = m_itemObj;
	    this.merchantObj = m_merchantObj;
	    this.price=t_price;
	    this.stock=t_stock;
	}
	public MerchantStock() {
		super();
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public ItemInfo getItemObj() {
		return itemObj;
	}
	public void setItemObj(ItemInfo itemObj) {
		this.itemObj = itemObj;
	}
	public MerchantDetails getMerchantObj() {
		return merchantObj;
	}
	public void setMerchantObj(MerchantDetails merchantObj) {
		this.merchantObj = merchantObj;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "MerchantStock [stock_id=" + stock_id + ", itemObj=" + itemObj + ", merchantObj=" + merchantObj
				+ ", price=" + price + ", stock=" + stock + "]";
	}
	

}
