package DiUSShopping.CheckoutSystem;

import static DiUSShopping.CheckoutSystem.model.Catalogue.getCatalogue;
import static DiUSShopping.CheckoutSystem.util.Constants.ATV;
import static DiUSShopping.CheckoutSystem.util.Constants.VGA;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import DiUSShopping.CheckoutSystem.checkout.Checkout;
import DiUSShopping.CheckoutSystem.util.NonRecognizedItemException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Welcome to our store!");
        System.out.println("Please enter a list of items you'd like to buy,"
        		+ " separated by comma (ipd, mbp, atv, vga): ");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String input = reader.readLine();
        
        try {
	        String[] items = input.split(",");
	        
	        Checkout checkout = new Checkout();
	        for(String item : items) {
	        	checkout.scan(getCatalogue().createItem(item.trim()));
	        }
	    	checkout.total();
	    	System.out.println("Your cart is estimated as: $" + checkout.getTotalPrice().getAmount());
        } catch (NonRecognizedItemException e) {
        	System.out.println("Sorry we could not recognize the items you typed in...");
        	System.exit(1);
        } catch (Exception e) {
        	System.out.println("Sorry an error happened while processing your request...");
        	System.exit(1);
        }
    }
}
