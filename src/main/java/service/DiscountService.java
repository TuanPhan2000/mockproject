package service;

import model.Discount;

import java.util.List;

public interface DiscountService {
    boolean saveDiscount(Discount inputNewDiscount);

    List<Discount> getAllDiscounts();

    int updateDiscount(Discount inputUpdateDiscount);

    boolean removeDiscount(int inputRemoveDiscount);

    Discount findDiscountById(int discountId);
}
