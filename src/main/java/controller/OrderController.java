package controller;

import model.Order;
import util.Constain;

import java.util.List;

public class OrderController {

    public int addOrder(){

        return Constain.orderService.addOrder(Constain.inputAddOrder());

    }

    public List<Order> getAllOrders() {

        return Constain.orderService.getAllOrders();

    }

    public boolean updateOrder(){

        return Constain.orderService.updateOrder(Constain.inputUpdateOrder());

    }

    public boolean removeOrder() {

        return Constain.orderService.removeOrder(Constain.inputRemoveOrder());

    }
}
