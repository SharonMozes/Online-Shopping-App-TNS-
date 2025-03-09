package entities;

import java.util.HashMap;

public class Order {
    private int orderId;
    private Customer customer;
    private HashMap<Product, Integer> products;
    private String status;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new HashMap<>();
        this.status = "Pending";
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
