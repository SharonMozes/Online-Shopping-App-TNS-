package services;

import entities.Customer;
import java.util.ArrayList;

public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    public void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println("User ID: " + customer.getUserId() + ", Name: " + customer.getUsername() + ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
        }
    }
}
