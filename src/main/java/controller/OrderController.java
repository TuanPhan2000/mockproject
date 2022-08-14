package controller;

import util.Constain;

public class OrderController {

    public int addOrder(){

        return Constain.orderService.addOrder(Constain.inputAddOrder());

    }

}
