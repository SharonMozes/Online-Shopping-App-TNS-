package entities;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Product> managedProducts;

    public Admin(int userId, String username, String email) {
        super(userId, username, email);
        this.managedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        managedProducts.add(product);
    }

    public void removeProduct(Product product) {
        managedProducts.remove(product);
    }
}
