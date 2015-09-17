package shopping.checkoutsystem.checkout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import shopping.checkoutsystem.model.Item;
import shopping.checkoutsystem.model.Price;

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
		System.out.println("Content of the cart: " + cart);
		computeCartTotal();
		System.out.println("Total before discount = " + getTotalPrice());
		pricingRules.computeDiscounts(cart);
		computeCartTotal();
		System.out.println("Total after discount = " + getTotalPrice());
	}

	public double getTotalPrice() {
		return new BigDecimal(totalPrice.getAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
