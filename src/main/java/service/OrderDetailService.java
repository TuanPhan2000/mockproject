package service;

import model.OrderDetail;

public interface OrderDetailService {

    boolean saveOrderDetail(OrderDetail orderDetail);

    boolean removeOrderDetailByOrderId(int inputRemoveOrder);
}
