package shopping.checkoutsystem.offer;

import static org.junit.Assert.assertTrue;
import static shopping.checkoutsystem.model.Catalogue.getCatalogue;
import static shopping.checkoutsystem.util.Constants.IPD;
import static shopping.checkoutsystem.util.Constants.MBP;
import static shopping.checkoutsystem.util.Constants.VGA;

import org.junit.Test;

import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.util.NonRecognizedItemException;

public class FreeBundleOfferTest {

	@Test
	public void testFreeBundle() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(MBP));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 1949.98 );
    }

	@Test
	public void testNoFreeBundle() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 579.99 );
    }
}
