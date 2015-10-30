package shopping.checkoutsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.model.Cart;
import shopping.checkoutsystem.model.Catalogue;
import shopping.checkoutsystem.model.Item;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Catalogue catalogue;
    @Autowired
    private Checkout checkout;

    @RequestMapping(value="/products", method= RequestMethod.GET)
    public Collection<Item> getAllItems() {
        return catalogue.getProductsMap().values();
    }

    @RequestMapping(value="/cart/add", method= RequestMethod.POST)
    public void addToCart(@RequestBody String sku) {
        checkout.scan(catalogue.getProductsMap().get(sku));
    }

    @RequestMapping(value="/cart/delete/{id}", method= RequestMethod.DELETE)
    public void removeFromCart(@PathVariable(value = "id") Integer id) {
        checkout.remove(id);
    }

    @RequestMapping(value="/cart", method= RequestMethod.GET)
    public Cart getCart() {
        checkout.total();
        return checkout.getCart();
    }
}
