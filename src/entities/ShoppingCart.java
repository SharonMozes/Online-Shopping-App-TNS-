package entities;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public HashMap<Product, Integer> getItems() { return items; }
}

