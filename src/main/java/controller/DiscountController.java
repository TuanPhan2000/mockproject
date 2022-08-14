package controller;

import model.Discount;
import model.Product;
import service.DiscountService;
import service.ProductService;
import service.serviceImpl.DiscountServiceImpl;
import service.serviceImpl.ProductServiceImpl;
import util.Constain;

import java.util.List;

public class DiscountController {

    public DiscountController() {
    }

    public boolean saveDiscount(){
        return Constain.discountService.saveDiscount(Constain.inputNewDiscount());
    }

    public List<Discount> getAllDiscounts() {
        return Constain.discountService.getAllDiscounts();
    }

    public int updateDiscount(){
        return Constain.discountService.updateDiscount(Constain.inputUpdateDiscount());
    }

    public boolean removeDiscount(){
        return Constain.discountService.removeDiscount(Constain.inputRemoveDiscount());
    }

}
