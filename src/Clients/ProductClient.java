package Clients;

import Interfaces.IProductService;
import Serializebles.Product;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ProductClient {
    public static void main(String[] args) {
        try {
            IProductService service = (IProductService) Naming.lookup("rmi://localhost:1101/ProductService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Product");
                System.out.println("2. Delete Product");
                System.out.println("3. List Products");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter product ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        Product product = new Product(id, name, quantity);
                        service.addProduct(product);
                        System.out.println("Product added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter product ID to delete: ");
                        String idToDelete = scanner.nextLine();
                        service.deleteProduct(idToDelete);
                        System.out.println("Product deleted successfully.");
                        break;
                    case 3:
                        List<Product> products = service.listProducts();
                        for (Product p : products) {
                            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Quantity: " + p.getQuantity());
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}