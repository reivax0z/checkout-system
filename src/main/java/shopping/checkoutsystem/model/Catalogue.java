package shopping.checkoutsystem.model;

import org.springframework.stereotype.Component;
import shopping.checkoutsystem.util.NonRecognizedItemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static shopping.checkoutsystem.util.Constants.*;

@Component
public class Catalogue {

	private static Catalogue instance = new Catalogue();
	
	private Catalogue() {
	}
	
	public static Catalogue getCatalogue() {
		return instance;
	}
	
	public Item createItem(String type) throws NonRecognizedItemException {
		return getProductsMap().get(type);
    }

	public Map<String, Item> getProductsMap(){
		Map<String, Item> items = new HashMap<>();
		items.put(IPD, new Item(IPD, new Product("Super iPad"), new Price(549.99)));
		items.put(MBP, new Item(MBP, new Product("MacBook Pro"), new Price(1399.99)));
		items.put(ATV, new Item(ATV, new Product("Apple TV"), new Price(109.50)));
		items.put(VGA, new Item(VGA, new Product("VGA adapter"), new Price(30.00)));
		return items;
	}
}
