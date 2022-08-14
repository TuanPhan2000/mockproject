package service.serviceImpl;

import dao.DiscountDAO;
import model.Discount;
import service.DiscountService;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    DiscountDAO discountDAO = new DiscountDAO();

    @Override
    public boolean saveDiscount(Discount inputNewDiscount) {
        return discountDAO.saveDiscount(inputNewDiscount);
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return discountDAO.getAllDiscounts();
    }

    @Override
    public int updateDiscount(Discount inputUpdateDiscount) {
        return discountDAO.updateDiscount(inputUpdateDiscount);
    }

    @Override
    public boolean removeDiscount(int inputRemoveDiscount) {
        return discountDAO.removeDiscount(inputRemoveDiscount);
    }

    @Override
    public Discount findDiscountById(int discountId) {
        return discountDAO.findDiscountById(discountId);
    }
}
