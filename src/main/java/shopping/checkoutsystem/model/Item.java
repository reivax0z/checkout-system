package shopping.checkoutsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class,property="@UUID")
public class Item {
	String sku;
	Integer id;
	Product product;
	Price unitPrice;
	
	public Item(String sku, Product product, Price unitPrice) {
		super();
		this.sku = sku;
		this.product = product;
		this.unitPrice = unitPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Price getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Price unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object other) {
	    if (other instanceof Item) {
	    	return this.sku.equals(((Item) other).getSku());
	    }
	    return false;
	}
	@Override
	public String toString() {
		return "Item [sku=" + sku + ", product=" + product + ", unitPrice="
				+ unitPrice + "]";
	}
}
