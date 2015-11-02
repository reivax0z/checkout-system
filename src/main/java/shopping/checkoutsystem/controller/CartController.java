package shopping.checkoutsystem.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shopping.checkoutsystem.checkout.Checkout;
import shopping.checkoutsystem.model.Cart;
import shopping.checkoutsystem.model.Catalogue;

@Api(basePath = "/cart", value = "Cart", description = "Content of the Cart", produces = "application/json")
@RestController
@RequestMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {

    @Autowired
    private Catalogue catalogue;
    @Autowired
    private Checkout checkout;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public void addToCart(@RequestBody String sku) {
        checkout.scan(catalogue.getProductsMap().get(sku));
    }

    @RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE)
    public void removeFromCart(@PathVariable(value = "id") Integer id) {
        checkout.remove(id);
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public Cart getCart() {
        checkout.total();
        return checkout.getCart();
    }
}
