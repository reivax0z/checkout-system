package shopping.checkoutsystem.offer;

import java.util.List;

import shopping.checkoutsystem.model.Item;

public interface Offer {
	void applyOffer(List<Item> items);
}
