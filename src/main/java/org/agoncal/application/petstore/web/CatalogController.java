package org.agoncal.application.petstore.web;

import org.agoncal.application.petstore.domain.Item;
import org.agoncal.application.petstore.domain.Product;
import org.agoncal.application.petstore.service.CatalogService;
import org.agoncal.application.petstore.util.Loggable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Getter;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Named
// @RequestScoped TODO should be request scoped
@SessionScoped
@Loggable
@CatchException
@Setter
@Getter
public class CatalogController extends Controller implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================

    @Inject
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private CatalogService catalogService;

    private String categoryName;
    private Long productId;
    private Long itemId;

    private String keyword;
    private Product product;
    private Item item;
    @Setter(AccessLevel.NONE)
    private List<Product> products;
    @Setter(AccessLevel.NONE)
    private List<Item> items;

    // ======================================
    // = Public Methods =
    // ======================================

    public String doFindProducts() {
        products = catalogService.findProducts(categoryName);
        return "showproducts.faces";
    }

    public String doFindItems() {
        product = catalogService.findProduct(productId);
        items = catalogService.findItems(productId);
        return "showitems.faces";
    }

    public String doFindItem() {
        item = catalogService.findItem(itemId);
        return "showitem.faces";
    }

    public String doSearch() {
        items = catalogService.searchItems(keyword);
        return "searchresult.faces?keyword=" + keyword + "&faces-redirect=true";
    }

    // ======================================
    // = Getters & setters =
    // ======================================


