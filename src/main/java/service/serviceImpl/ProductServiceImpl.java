package service.serviceImpl;

import dao.ProductDAO;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAO();

    @Override
    public boolean saveProduct(Product inputProduct) {
        return productDAO.saveProduct(inputProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public int updateProduct(Product inputUpdateProduct) {
        return productDAO.updateProduct(inputUpdateProduct);
    }

    @Override
    public boolean removeProduct(int inputRemoveProduct) {
        return productDAO.removeProduct(inputRemoveProduct);
    }

    @Override
    public boolean checkStock(int product_id, int quantity) {
        return productDAO.checkStock(product_id, quantity);
    }

    @Override
    public boolean updateStockAndSold(int product_id, int quantity) {
        return productDAO.updateStockAndSold(product_id, quantity);
    }

    @Override
    public boolean updateStatus0() {
        return productDAO.updateStatus0();
    }

    @Override
    public boolean updateStatus1() {
        return productDAO.updateStatus1();
    }
}
