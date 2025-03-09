package entities;

import java.util.ArrayList;

public class Customer extends User {
    private String address;
    private ShoppingCart shoppingCart;
    private ArrayList<Order> orders;

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.shoppingCart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public ArrayList<Order> getOrders() { return orders; }
}
