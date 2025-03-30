package Interfaces;

import Serializebles.Product;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProductService extends Remote {
    void addProduct(Product product) throws RemoteException;
    void deleteProduct(String id) throws RemoteException;
    List<Product> listProducts() throws RemoteException;
}