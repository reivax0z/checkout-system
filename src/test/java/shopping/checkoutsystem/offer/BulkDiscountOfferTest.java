package shopping.checkoutsystem.offer;

import static org.junit.Assert.assertTrue;
import static shopping.checkoutsystem.model.Catalogue.getCatalogue;
import static shopping.checkoutsystem.util.Constants.ATV;
import static shopping.checkoutsystem.util.Constants.IPD;

import org.junit.Test;

import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.util.NonRecognizedItemException;

public class BulkDiscountOfferTest {

	@Test
	public void testPriceDropOver4() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 2718.95 );
    }

	@Test
	public void testPriceDropOver4DifferentOrder() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 2718.95 );
    }

	@Test
	public void testPriceStillDropOver7() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 3218.94 );
    }

	@Test
	public void testPriceNoDropBelow4() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 1868.97 );
    }
}
