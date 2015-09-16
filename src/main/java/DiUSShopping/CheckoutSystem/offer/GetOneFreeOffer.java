package DiUSShopping.CheckoutSystem.offer;

import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;
import DiUSShopping.CheckoutSystem.model.Price;

public class GetOneFreeOffer extends AbstractOffer implements Offer {

	String product;
	int quantityThreshold;
	
	public GetOneFreeOffer(String product, int quantityThreshold){
		this.product = product;
		this.quantityThreshold = quantityThreshold;
	}
	
	public void applyOffer(List<Item> items) {
		List<Item> discountedItems = getSubListOfEligibleItems(items);
		if(discountedItems.size() >= quantityThreshold) {
			items.removeAll(discountedItems);
			int nbFreeItems = discountedItems.size() / quantityThreshold;
			for(int i=0;i<nbFreeItems;i++) {
				discountedItems.get(i).setUnitPrice(new Price(0));
			}
			items.addAll(discountedItems);
		}
	}

	@Override
	protected boolean isItemEligible(Item item) {
		return item.getSku().equals(product);
	}
}
