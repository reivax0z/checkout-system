package shopping.checkoutsystem.checkout;

import java.util.ArrayList;
import java.util.List;

import shopping.checkoutsystem.model.Item;
import shopping.checkoutsystem.model.Price;
import shopping.checkoutsystem.model.Product;
import shopping.checkoutsystem.offer.BulkDiscountOffer;
import shopping.checkoutsystem.offer.FreeBundleOffer;
import shopping.checkoutsystem.offer.GetOneFreeOffer;
import shopping.checkoutsystem.offer.Offer;
import static shopping.checkoutsystem.util.Constants.*;


public class PricingRules implements Rules {
	List<Offer> offers;
	
	private static PricingRules instance = new PricingRules();
	
	private PricingRules() {
		offers = new ArrayList<Offer>();
		initialize();
	}
	
	public static PricingRules getInstance() {
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
