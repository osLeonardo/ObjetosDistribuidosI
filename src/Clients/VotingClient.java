package Clients;

import Interfaces.IVotingService;

import java.rmi.Naming;
import java.util.Map;
import java.util.Scanner;

public class VotingClient {
    public static void main(String[] args) {
        try {
            IVotingService service = (IVotingService) Naming.lookup("rmi://localhost:1104/VotingService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Vote");
                System.out.println("2. View Results");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter option to vote for: ");
                        String option = scanner.nextLine();
                        service.vote(option);
                        System.out.println("Vote cast successfully.");
                        break;
                    case 2:
                        Map<String, Integer> results = service.getResults();
                        for (Map.Entry<String, Integer> entry : results.entrySet()) {
                            System.out.println("Option: " + entry.getKey() + ", Votes: " + entry.getValue());
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