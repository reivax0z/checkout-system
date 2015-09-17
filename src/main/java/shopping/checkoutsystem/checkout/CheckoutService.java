package shopping.checkoutsystem.checkout;

import shopping.checkoutsystem.model.Item;

public interface CheckoutService {
	void scan(Item item);
	void total();
}
