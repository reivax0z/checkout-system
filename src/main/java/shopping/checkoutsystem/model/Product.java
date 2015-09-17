package shopping.checkoutsystem.model;

public class Product {
	String name;
	
	public Product(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}
}
