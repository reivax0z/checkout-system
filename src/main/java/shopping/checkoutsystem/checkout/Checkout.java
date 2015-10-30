package shopping.checkoutsystem.checkout;

import org.springframework.stereotype.Component;
import shopping.checkoutsystem.model.Cart;
import shopping.checkoutsystem.model.Item;
import shopping.checkoutsystem.model.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Component
public class Checkout implements CheckoutService {

	PricingRules pricingRules;
	Cart cart;
	Price totalPrice;
	Random random;
	
	public Checkout() {
		this.pricingRules = PricingRules.getInstance();
		this.cart = new Cart();
		this.random = new Random();
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
		item.setId(random.nextInt(100));
		cart.add(item);
		cart.setNbItems(cart.getContent().size());
	}

	public void remove(Integer itemId) {
		cart.remove(itemId);
		cart.setNbItems(cart.getContent().size());
	}
	
	public void total() {
		System.out.println("Content of the cart: " + cart.getContent().size());
		computeCartTotal();
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
