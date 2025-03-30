package Services;

import Interfaces.IUpperCaseService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpperCaseService extends UnicastRemoteObject implements IUpperCaseService {
    public UpperCaseService() throws RemoteException {
        super();
    }

    @Override
    public String toUpperCase(String input) throws RemoteException {
        return input.toUpperCase();
    }
}