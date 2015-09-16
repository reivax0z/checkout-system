package DiUSShopping.CheckoutSystem.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static DiUSShopping.CheckoutSystem.util.Constants.*;

public class Catalogue {

	private static Catalogue instance = new Catalogue();
	
	private Catalogue() {
	}
	
	public static Catalogue getCatalogue() {
		return instance;
	}
	
	public Item createItem(String type) {
		switch(type){
		case IPD: return new Item(IPD, new Product("Super iPad"), new Price(549.99));
		case MBP: return new Item(MBP, new Product("MacBook Pro"), new Price(1399.99));
		case ATV: return new Item(ATV, new Product("Apple TV"), new Price(109.50));
		case VGA: return new Item(VGA, new Product("VGA adapter"), new Price(30.00));
		default: return null;
		}
    }
}
