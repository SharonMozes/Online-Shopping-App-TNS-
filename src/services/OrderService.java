package services;

import entities.Order;
import java.util.ArrayList;

public class OrderService {
    private ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully!");
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.updateStatus(status);
                System.out.println("Order status updated to: " + status);
                return;
            }
        }
    }
}
