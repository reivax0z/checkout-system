package DiUSShopping.CheckoutSystem.model;

public class Price {
	double amount;
	
	public Price(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void add(Price p) {
		this.amount = this.amount + p.amount;
	}

	@Override
	public String toString() {
		return "Price [amount=" + amount + "]";
	}
}
