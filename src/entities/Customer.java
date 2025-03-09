package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private ShoppingCart shoppingCart;
    private List<Order> orders;

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.shoppingCart = new ShoppingCart();
        this.orders = new ArrayList<>();
    }

    public ShoppingCart getShoppingCart() { return shoppingCart; }
    public List<Order> getOrders() { return orders; }

    public void placeOrder() {
        Order order = new Order(this, shoppingCart.getItems());
        orders.add(order);
        shoppingCart.clearCart();
        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer [ID: " + userId + ", Name: " + username + ", Email: " + email + ", Address: " + address + "]");
    }
}
