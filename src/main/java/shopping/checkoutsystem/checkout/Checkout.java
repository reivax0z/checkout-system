package shopping.checkoutsystem.checkout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import shopping.checkoutsystem.model.Cart;
import shopping.checkoutsystem.model.Item;
import shopping.checkoutsystem.model.Price;

@Component
public class Checkout implements CheckoutService {

	PricingRules pricingRules;
	Cart cart;
	Price totalPrice;
	
	public Checkout() {
		this.pricingRules = PricingRules.getInstance();
		this.cart = new Cart();
	}
	
	private void computeCartTotal() {
		totalPrice = new Price(0);
		for(Item item : cart.getContent()) {
			totalPrice.add(item.getUnitPrice());
		}
	}

	public Cart getCart() {
		return cart;
	}

	public void scan(Item item) {
		cart.add(item);
	}
	
	public void total() {
		System.out.println("Content of the cart: " + cart.getContent().size());
		computeCartTotal();
		cart.setTotalPriceBeforeDiscount(getTotalPrice());
		System.out.println("Total before discount = " + getTotalPrice());
		pricingRules.computeDiscounts(cart.getContent());
		computeCartTotal();
		cart.setTotalPriceAfterDiscount(getTotalPrice());
		System.out.println("Total after discount = " + getTotalPrice());
	}

	public double getTotalPrice() {
		return new BigDecimal(totalPrice.getAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
