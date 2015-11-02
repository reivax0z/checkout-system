package shopping.checkoutsystem.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shopping.checkoutsystem.model.Catalogue;
import shopping.checkoutsystem.model.Item;

import java.util.Collection;

@Api(basePath = "/catalogue", value = "Catalogue", description = "Content of the Catalogue", produces = "application/json")
@RestController
@RequestMapping(value = "/catalogue", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogueController {

    @Autowired
    private Catalogue catalogue;

    @RequestMapping(value="", method= RequestMethod.GET)
    public Collection<Item> getAllItems() {
        return catalogue.getProductsMap().values();
    }
}
