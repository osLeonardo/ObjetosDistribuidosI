package Services;

import Interfaces.IBookService;
import Serializebles.Book;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) throws RemoteException {
        books.add(book);
    }

    @Override
    public void deleteBook(String title) throws RemoteException {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    @Override
    public List<Book> listBooks() throws RemoteException {
        return new ArrayList<>(books);
    }
}