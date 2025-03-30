package Servers;

import Interfaces.IBookService;
import Services.BookService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BookServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1100);

            IBookService bookService = new BookService();
            IBookService stub;
            try {
                stub = (IBookService) UnicastRemoteObject.exportObject(bookService, 0);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("Object already exported: " + e.getMessage());
                stub = bookService;
            }

            registry.rebind("BookService", stub);

            System.out.println("BookServer is running on port 1100");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}