package Servers;

import Interfaces.IStudentService;
import Services.StudentService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class StudentServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1102);
            IStudentService studentService = new StudentService();
            IStudentService stub;
            try {
                stub = (IStudentService) UnicastRemoteObject.exportObject(studentService, 0);
            } catch (java.rmi.server.ExportException e) {
                System.err.println("Object already exported: " + e.getMessage());
                stub = studentService;
            }

            Naming.rebind("rmi://localhost:1102/StudentService", stub);
            System.out.println("StudentService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}