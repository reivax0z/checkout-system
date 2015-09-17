package shopping.checkoutsystem;

import static shopping.checkoutsystem.model.Catalogue.getCatalogue;
import static shopping.checkoutsystem.util.Constants.EXIT_COMMAND;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.util.NonRecognizedItemException;

/**
 * Main entry point for launching the application.
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("---");
        System.out.println("Welcome to our store!");
        System.out.println("To quit, type 'exit'");
        
        while(true) {
        	System.out.println("---");
	        System.out.println("Please enter a list of items you'd like to buy,"
	        		+ " separated by comma (ipd, mbp, atv, vga): ");
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                System.in));
	        String input = reader.readLine();
	        
	        try {
	        	if(input.equalsIgnoreCase(EXIT_COMMAND)){
	            	System.out.println("---");
	                System.out.println("Thank you for chosing our store!");
	        		System.exit(0);
	        	}
		        String[] items = input.split(",");
		        
		        Checkout checkout = new Checkout();
		        for(String item : items) {
		        	checkout.scan(getCatalogue().createItem(item.trim()));
		        }
		    	checkout.total();
		    	System.out.println("Your cart is estimated as: $" + checkout.getTotalPrice());
	        } catch (NonRecognizedItemException e) {
	        	System.out.println("Sorry we could not recognize the items you typed in...");
	        	System.exit(1);
	        } catch (Exception e) {
	        	System.out.println("Sorry an error happened while processing your request...");
	        	System.exit(1);
	        }
        }
    }
}
