package DiUSShopping.CheckoutSystem.offer;

import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;

public interface Offer {
	void applyOffer(List<Item> items);
}
