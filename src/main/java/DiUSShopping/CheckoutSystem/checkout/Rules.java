package DiUSShopping.CheckoutSystem.checkout;

import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;

public interface Rules {
	void computeDiscounts(List<Item> items);
}
