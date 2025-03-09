package entities;

import java.util.*;

public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static Admin admin = new Admin(1, "Admin", "admin@example.com");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> adminMenu(sc);
                case 2 -> customerMenu(sc);
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (choice != 3);
    }

    private static void adminMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Return");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = sc.nextInt();
                    admin.addProduct(new Product(id, name, price, stock));
                }
                case 2 -> {
                    System.out.print("Enter Product ID to remove: ");
                    int id = sc.nextInt();
                    admin.removeProduct(id);
                }
                case 3 -> admin.viewProducts();
                case 4 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (option != 4);
    }

    private static void customerMenu(Scanner sc) {
        System.out.print("Enter Customer ID (or 0 to create a new customer): ");
        int customerId = sc.nextInt();
        Customer customer = customers.stream()
                .filter(c -> c.userId == customerId)
                .findFirst()
                .orElseGet(() -> createCustomer(sc));

        int option;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Return");
            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> admin.viewProducts();
                case 2 -> {
                    System.out.print("Enter Product ID to add to cart: ");
                    int productId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    Product product = admin.getProducts().stream()
                            .filter(p -> p.getProductId() == productId)
                            .findFirst()
                            .orElse(null);

                    if (product != null) {
                        customer.getShoppingCart().addProduct(product, quantity);
                        System.out.println("Product added to cart!");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 3 -> customer.getShoppingCart().viewCart();
                case 4 -> {
                    customer.placeOrder();
                }
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (option != 5);
    }

    private static Customer createCustomer(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();
        System.out.print("Enter Address: ");
        String address = sc.next();
        Customer customer = new Customer(customers.size() + 1, name, email, address);
        customers.add(customer);
        System.out.println("Customer created successfully!");
        return customer;
    }
}
