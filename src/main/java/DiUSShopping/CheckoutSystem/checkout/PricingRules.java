package DiUSShopping.CheckoutSystem.checkout;

import java.util.ArrayList;
import java.util.List;

import DiUSShopping.CheckoutSystem.model.Item;
import DiUSShopping.CheckoutSystem.model.Price;
import DiUSShopping.CheckoutSystem.model.Product;
import DiUSShopping.CheckoutSystem.offer.BulkDiscountOffer;
import DiUSShopping.CheckoutSystem.offer.FreeBundleOffer;
import DiUSShopping.CheckoutSystem.offer.GetOneFreeOffer;
import DiUSShopping.CheckoutSystem.offer.Offer;
import static DiUSShopping.CheckoutSystem.util.Constants.*;


public class PricingRules implements Rules {
	List<Offer> offers;
	
	private static PricingRules instance = new PricingRules();
	
	private PricingRules() {
		offers = new ArrayList<Offer>();
	}
	
	public static PricingRules getInstance() {
		instance.initialize();
		return instance;
	}

	public void computeDiscounts(List<Item> items) {
		for(Offer offer : offers) {
			offer.applyOffer(items);
		}
	}

	private void initialize() {
		offers.add(new GetOneFreeOffer(ATV, 3));
		offers.add(new BulkDiscountOffer(IPD, new Price(499.99), 4));
		offers.add(new FreeBundleOffer(MBP, VGA));
	}
}
