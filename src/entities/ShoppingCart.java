package entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
        } else {
            items.forEach((product, quantity) ->
                System.out.println(product + " | Quantity: " + quantity)
            );
        }
    }
}
