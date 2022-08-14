package dao;

import model.Order;
import model.OrderDetail;
import model.Product;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Order> getAllOrders() {

        List<Order> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.getAllOrderSQL);
            while(resultSet.next()){
                list.add(new Order(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getDouble(5), resultSet.getDate(6).toLocalDate(),
                        Constain.customerService.findCustomerById(resultSet.getInt(7)),
                        Constain.addressService.findAddressById(resultSet.getInt(8)),
                        Constain.discountService.findDiscountById(resultSet.getInt(9))));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

    public boolean removeOrder(int inputRemoveOrder) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            if(Constain.orderDetailService.removeOrderDetailByOrderId(inputRemoveOrder)){
                PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.removeOrderById);
                preparedStatement.setInt(1,inputRemoveOrder);
                preparedStatement.executeUpdate();
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateOrder(Order inputUpdateOrder) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

          PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateOrderSQL);
          preparedStatement.setString(1, inputUpdateOrder.getName());
          preparedStatement.setString(2, inputUpdateOrder.getPhoneNumber());
          preparedStatement.setString(3, inputUpdateOrder.getDetailAddress());
          preparedStatement.setInt(4, inputUpdateOrder.getOrderId());
          preparedStatement.executeUpdate();

          return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
