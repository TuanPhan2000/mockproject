package service.serviceImpl;

import dao.OrderDetailDAO;
import model.OrderDetail;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    @Override
    public boolean saveOrderDetail(OrderDetail orderDetail) {

        return orderDetailDAO.saveOrderDetail(orderDetail);
    }

    @Override
    public boolean removeOrderDetailByOrderId(int inputRemoveOrder) {
        return orderDetailDAO.removeOrderDetailByOrderId(inputRemoveOrder);
    }
}
