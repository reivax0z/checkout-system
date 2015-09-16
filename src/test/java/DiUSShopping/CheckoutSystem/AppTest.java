package DiUSShopping.CheckoutSystem;

import DiUSShopping.CheckoutSystem.checkout.Checkout;
import DiUSShopping.CheckoutSystem.util.NonRecognizedItemException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static DiUSShopping.CheckoutSystem.model.Catalogue.getCatalogue;
import static DiUSShopping.CheckoutSystem.util.Constants.*;

public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testBuy3Get1Free() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(ATV));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.total();
        assertTrue( checkout.getTotalPrice().getAmount() == 249.00 );
    }
    
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
        assertTrue( checkout.getTotalPrice().getAmount() == 2718.95 );
    }
    
    public void testFreeBundle() throws NonRecognizedItemException
    {
    	Checkout checkout = new Checkout();
    	checkout.scan(getCatalogue().createItem(MBP));
    	checkout.scan(getCatalogue().createItem(VGA));
    	checkout.scan(getCatalogue().createItem(IPD));
    	checkout.total();
        assertTrue( checkout.getTotalPrice().getAmount() == 1949.98 );
    }
}
