package Services;

import Interfaces.IProductService;
import Serializebles.Product;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) throws RemoteException {
        products.add(product);
    }

    @Override
    public void deleteProduct(String id) throws RemoteException {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public List<Product> listProducts() throws RemoteException {
        return new ArrayList<>(products);
    }
}