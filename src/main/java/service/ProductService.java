package service;

import model.Product;

import java.util.List;

public interface ProductService {

    boolean saveProduct(Product inputProduct);

    List<Product> getAllProducts();

    int updateProduct(Product inputUpdateProduct);

    boolean removeProduct(int inputRemoveProduct);

    boolean checkStock(int product_id, int quantity);

    boolean updateStockAndSold(int product_id,int quantity);

    boolean updateStatus0();
    boolean updateStatus1();
}
