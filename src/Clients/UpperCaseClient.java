package Clients;

import Interfaces.IUpperCaseService;

import java.rmi.Naming;
import java.util.Scanner;

public class UpperCaseClient {
    public static void main(String[] args) {
        try {
            IUpperCaseService service = (IUpperCaseService) Naming.lookup("rmi://localhost:1103/UpperCaseService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a string to convert to uppercase (or type 'exit' to quit):");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
                String result = service.toUpperCase(input);
                System.out.println("Result: " + result);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}