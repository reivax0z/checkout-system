package shopping.checkoutsystem.offer;

import java.util.ArrayList;
import java.util.List;

import shopping.checkoutsystem.model.Item;

public abstract class AbstractOffer implements Offer {
	
	// method to retrieve the list of eligible items matching a product rule
	protected List<Item> getSubListOfEligibleItems(List<Item> initialList) {
		List<Item> list = new ArrayList<Item>();
		for(Item item : initialList) {
			if(isItemEligible(item)) {
				list.add(item);
			}
		}
		return list;
	}

	protected abstract boolean isItemEligible(Item item);
}
