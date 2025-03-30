package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUpperCaseService extends Remote {
    String toUpperCase(String input) throws RemoteException;
}
