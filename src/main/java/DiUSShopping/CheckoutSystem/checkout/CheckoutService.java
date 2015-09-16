package DiUSShopping.CheckoutSystem.checkout;

import DiUSShopping.CheckoutSystem.model.Item;

public interface CheckoutService {
	void scan(Item item);
	void total();
}
