package Servers;

import Interfaces.IVotingService;
import Services.VotingService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class VotingServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1104);
            IVotingService votingService = new VotingService();
            IVotingService stub;
            try {
                stub = (IVotingService) UnicastRemoteObject.exportObject(votingService, 0);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("Object already exported: " + e.getMessage());
                stub = votingService;
            }

            Naming.rebind("rmi://localhost:1104/VotingService", stub);
            System.out.println("VotingService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}