package entities;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Product> products;

    public Admin(int userId, String username, String email) {
        super(userId, username, email);
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
        System.out.println("Product removed successfully!");
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.forEach(System.out::println);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin [ID: " + userId + ", Name: " + username + ", Email: " + email + "]");
    }
}
