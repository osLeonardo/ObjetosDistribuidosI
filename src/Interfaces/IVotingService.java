package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IVotingService extends Remote {
    void vote(String option) throws RemoteException;
    Map<String, Integer> getResults() throws RemoteException;
}