package services;

import entities.Product;
import java.util.ArrayList;

public class AdminService {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
        System.out.println("Product removed successfully!");
    }

    public void viewProducts() {
        for (Product product : products) {
            System.out.println(product.getProductId() + " - " + product.getName() + " - Price: " + product.getPrice() + " - Stock: " + product.getStockQuantity());
        }
    }
}
