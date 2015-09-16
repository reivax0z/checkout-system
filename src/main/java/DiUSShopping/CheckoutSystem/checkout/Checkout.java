package DiUSShopping.CheckoutSystem.checkout;

import java.util.ArrayList;
import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;
import DiUSShopping.CheckoutSystem.model.Price;

public class Checkout implements CheckoutService {

	PricingRules pricingRules;
	List<Item> cart;
	Price totalPrice;
	
	public Checkout() {
		this.pricingRules = PricingRules.getInstance();
		this.cart = new ArrayList<Item>();
	}
	
	private void computeCartTotal() {
		totalPrice = new Price(0);
		for(Item item : cart) {
			totalPrice.add(item.getUnitPrice());
		}
	}
	
	public void scan(Item item) {
		cart.add(item);
	}
	
	public void total() {
		computeCartTotal();
		System.out.println("Total before discount = " + totalPrice);
		pricingRules.computeDiscounts(cart);
		computeCartTotal();
		System.out.println("Total after discount = " + totalPrice);
	}

	public Price getTotalPrice() {
		return totalPrice;
	}
}
