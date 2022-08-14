package dao;

import model.OrderDetail;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDAO {
    public boolean saveOrderDetail(OrderDetail orderDetail) {

        try (Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.insertOrderDetailSQL);
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setDouble(2, orderDetail.getTotal());
            preparedStatement.setInt(3, orderDetail.getOrder().getOrderId());
            preparedStatement.setInt(4, orderDetail.getProduct().getProductId());
            preparedStatement.executeUpdate();

            Constain.productService.updateStockAndSold(orderDetail.getProduct().getProductId(), orderDetail.getQuantity());

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
