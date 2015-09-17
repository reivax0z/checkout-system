package shopping.checkoutsystem.checkout;

import java.util.List;

import shopping.checkoutsystem.model.Item;

public interface Rules {
	void computeDiscounts(List<Item> items);
}
