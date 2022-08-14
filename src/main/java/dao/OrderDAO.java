package dao;

import model.Order;
import model.OrderDetail;
import model.Product;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class OrderDAO {

    public OrderDAO() {
    }

    public int addOrder(Order inputAddOrder) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            if(inputAddOrder.getAddress().getAddressId() == 0){
                inputAddOrder.getAddress().setAddressId(Constain.addressService.addAddress(inputAddOrder.getAddress()));
            }

            PreparedStatement preparedStatement =null;
            if(inputAddOrder.getDiscount() != null){
                preparedStatement = connection.prepareStatement(SQLCommand.insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(8, inputAddOrder.getDiscount().getDiscountId());
            }

            else preparedStatement = connection.prepareStatement(SQLCommand.insertOrderNoDiscountSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, inputAddOrder.getName());
            preparedStatement.setString(2, inputAddOrder.getPhoneNumber());
            preparedStatement.setString(3, inputAddOrder.getDetailAddress());
            preparedStatement.setDouble(4, inputAddOrder.getTotal());
            preparedStatement.setDate(5, Date.valueOf(inputAddOrder.getOrderDate()));
            preparedStatement.setInt(6, inputAddOrder.getCustomer().getCustomerId());
            preparedStatement.setInt(7, inputAddOrder.getAddress().getAddressId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            inputAddOrder.setOrderId(resultSet.getInt(1));
            List<Product> listProduct = Constain.productService.getAllProducts();
            Set<Integer> set = Constain.mapDetailOrder.keySet();
            for(Integer key : set){

                int quantity = Constain.mapDetailOrder.get(key);
                Product product = listProduct.stream().filter(product1 -> product1.getProductId() ==  key).findFirst().orElse(null);
                double total = product.getPrice() * quantity;

                Constain.orderDetailService.saveOrderDetail(new OrderDetail(quantity, total, inputAddOrder, product));
            }

            Constain.mapDetailOrder.clear();

            return 1;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
