package Interfaces;

import Serializebles.Book;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBookService extends Remote {
    void addBook(Book book) throws RemoteException;
    void deleteBook(String title) throws RemoteException;
    List<Book> listBooks() throws RemoteException;
}