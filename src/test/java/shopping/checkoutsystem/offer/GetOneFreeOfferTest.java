package shopping.checkoutsystem.offer;

import static org.junit.Assert.assertTrue;
import static shopping.checkoutsystem.model.Catalogue.getCatalogue;
import static shopping.checkoutsystem.util.Constants.ATV;
import static shopping.checkoutsystem.util.Constants.VGA;

import org.junit.Test;

import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.util.NonRecognizedItemException;

public class GetOneFreeOfferTest {

	@Test
	public void testBuy3Get1Free() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 249.00 );
    }

	@Test
	public void testBuy3Get1FreeDifferentOrder() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 249.00 );
    }

	@Test
	public void testBuy4Get1Free() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 358.50 );
    }

	@Test
	public void testBuy2Get0Free() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 249.00 );
    }

	@Test
	public void testBuy6Get2Free() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.total();
        assertTrue( checkout.getTotalPrice() == 468.00 );
    }
}
