package DiUSShopping.CheckoutSystem.offer;

import java.util.ArrayList;
import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;
import DiUSShopping.CheckoutSystem.model.Price;
import static DiUSShopping.CheckoutSystem.model.Catalogue.getCatalogue;

public class FreeBundleOffer extends AbstractOffer implements Offer {

	String product;
	String freeProductBundled;
	
	public FreeBundleOffer(String product, String freeProductBundled){
		this.product = product;
		this.freeProductBundled = freeProductBundled;
	}
	
	public void applyOffer(List<Item> items) {
		List<Item> discountedItems = getSubListOfEligibleItems(items);
		List<Item> alreadyBundledItems = getCurrentBundledItems(items, discountedItems.size());
		
		// discounting current items for free
		if(alreadyBundledItems.size() > 0) {
			items.removeAll(alreadyBundledItems);
			for(Item item : alreadyBundledItems) {
				item.setUnitPrice(new Price(0));
			}
			items.addAll(alreadyBundledItems);
		}
		
		// adding missing items for free
		for(int i=alreadyBundledItems.size(); i<discountedItems.size(); i++) {
			items.add(getCatalogue().createItem(freeProductBundled));
		}
	}

	@Override
	protected boolean isItemEligible(Item item) {
		return item.getSku().equals(product);
	}
	
	private List<Item> getCurrentBundledItems(List<Item> initialList, int max) {
		List<Item> list = new ArrayList<Item>();
		int i=0;
		for(Item item : initialList) {
			if(item.getSku().equals(freeProductBundled) && i<max) {
				list.add(item);
				i++;
			}
		}
		return list;
	}
}
