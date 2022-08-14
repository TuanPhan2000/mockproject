package service;

import model.Order;

import java.util.List;

public interface OrderService {
    int addOrder(Order inputAddOrder);

    List<Order> getAllOrders();

    boolean removeOrder(int inputRemoveOrder);

    boolean updateOrder(Order inputUpdateOrder);
}
