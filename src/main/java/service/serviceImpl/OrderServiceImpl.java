package service.serviceImpl;

import dao.OrderDAO;
import model.Order;
import service.OrderService;
import util.Constain;

import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    OrderDAO orderDAO = new OrderDAO();
    Scanner scanner = new Scanner(System.in);

    @Override
    public int addOrder(Order inputAddOrder) {

        if(inputAddOrder == null) return 2;
        System.out.println("Bạn có chắc chắn muốn order ? Y để xác nhận, N để quay lại: ");
        if(scanner.nextLine().equals("N")){
            Constain.mapDetailOrder.clear();
            return 2;
        }
        else {
            return orderDAO.addOrder(inputAddOrder);
        }
    }
}
