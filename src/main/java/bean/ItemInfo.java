package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int item_id;
	private String name;
	private float price;
	private int stock;
	public ItemInfo(int t_item_id,String t_name,float t_price,int t_stock) {
		super();  
	    this.item_id = t_item_id;  
	    this.name = t_name;
	    this.price=t_price;
	    this.stock=t_stock;
	}
	public ItemInfo() {
		super();
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "ItemInfo [item_id=" + item_id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	

}
