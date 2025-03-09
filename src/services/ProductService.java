package services;

import entities.Product;
import java.util.ArrayList;

public class ProductService {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() { return products; }
}
