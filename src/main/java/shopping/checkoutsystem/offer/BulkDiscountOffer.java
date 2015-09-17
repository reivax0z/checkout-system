package shopping.checkoutsystem.offer;

import java.util.List;

import shopping.checkoutsystem.model.Item;
import shopping.checkoutsystem.model.Price;

public class BulkDiscountOffer extends AbstractOffer implements Offer {

	String product;
	Price ceilingPrice;
	int quantityThreshold;
	
	public BulkDiscountOffer(String product, Price ceilingPrice, int quantityThreshold){
		this.product = product;
		this.ceilingPrice = ceilingPrice;
		this.quantityThreshold = quantityThreshold;
	}
	
	public void applyOffer(List<Item> items) {
		List<Item> discountedItems = getSubListOfEligibleItems(items);
		if(discountedItems.size() > quantityThreshold) {
			items.removeAll(discountedItems);
			for(Item item : discountedItems) {
				item.setUnitPrice(ceilingPrice);
			}
			items.addAll(discountedItems);
		}
	}
	
	@Override
	protected boolean isItemEligible(Item item) {
		return item.getSku().equals(product);
	}
}
