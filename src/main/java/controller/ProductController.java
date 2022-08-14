package controller;

import model.Product;
import service.ProductService;
import service.serviceImpl.ProductServiceImpl;
import util.Constain;

import java.util.List;

public class ProductController {

    public ProductController() {
    }

    public boolean saveProduct(){
        return Constain.productService.saveProduct(Constain.inputNewProduct());
    }

    public List<Product> getAllProducts() {
        return Constain.productService.getAllProducts();
    }

    public int updateProduct(){
        return Constain.productService.updateProduct(Constain.inputUpdateProduct());
    }

    public boolean removeProduct(){
        return Constain.productService.removeProduct(Constain.inputRemoveProduct());
    }

}
