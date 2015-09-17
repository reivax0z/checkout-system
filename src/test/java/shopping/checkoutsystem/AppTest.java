package shopping.checkoutsystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import shopping.checkoutsystem.offer.BulkDiscountOfferTest;
import shopping.checkoutsystem.offer.FreeBundleOfferTest;
import shopping.checkoutsystem.offer.GetOneFreeOfferTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BulkDiscountOfferTest.class,
	FreeBundleOfferTest.class,
	GetOneFreeOfferTest.class
})
public class AppTest
{
}
