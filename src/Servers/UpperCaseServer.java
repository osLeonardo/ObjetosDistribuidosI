package Servers;

import Interfaces.IUpperCaseService;
import Services.UpperCaseService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class UpperCaseServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1103);
            IUpperCaseService upperCaseService = new UpperCaseService();
            IUpperCaseService stub;
            try {
                stub = (IUpperCaseService) UnicastRemoteObject.exportObject(upperCaseService, 0);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("Object already exported: " + e.getMessage());
                stub = upperCaseService;
            }

            Naming.rebind("rmi://localhost:1103/UpperCaseService", stub);
            System.out.println("UpperCaseService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}