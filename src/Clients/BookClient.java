package Clients;

import Interfaces.IBookService;
import Serializebles.Book;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class BookClient {
    public static void main(String[] args) {
        try {
            IBookService service = (IBookService) Naming.lookup("rmi://localhost:1100/BookService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. List Books");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        Book book = new Book(title, author, year);
                        service.addBook(book);
                        System.out.println("Book added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter title of the book to delete: ");
                        String titleToDelete = scanner.nextLine();
                        service.deleteBook(titleToDelete);
                        System.out.println("Book deleted successfully.");
                        break;
                    case 3:
                        List<Book> books = service.listBooks();
                        for (Book b : books) {
                            System.out.println("Title: " + b.getTitle() + ", Author: " + b.getAuthor() + ", Year: " + b.getYear());
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