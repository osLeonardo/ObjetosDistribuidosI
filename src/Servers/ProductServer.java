package Servers;

import Interfaces.IProductService;
import Services.ProductService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ProductServer {
    public static void main(String[] args) {
        try {
            try {
                LocateRegistry.createRegistry(1101);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("RMI registry already exists.");
            }

            IProductService productService = new ProductService();
            IProductService stub;
            try {
                stub = (IProductService) UnicastRemoteObject.exportObject(productService, 0);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("Object already exported: " + e.getMessage());
                stub = productService;
            }

            Naming.rebind("rmi://localhost:1101/ProductService", stub);
            System.out.println("ProductService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}