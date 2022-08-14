package dao;

import model.Product;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public boolean saveProduct(Product inputProduct) {

        try(Connection connection = DbUtil.getInstance().getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.insertProductSQL);
            preparedStatement.setString(1, inputProduct.getName());
            preparedStatement.setString(2, inputProduct.getDescription());
            preparedStatement.setDouble(3, inputProduct.getPrice());
            preparedStatement.setDouble(4, inputProduct.getDiscountPrice());
            preparedStatement.setInt(5, inputProduct.getStock());
            preparedStatement.setDate(6, Date.valueOf(inputProduct.getCreateDate()));

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.getAllProductsSQL);
            while(resultSet.next()){
                int productId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                double discountPrice = resultSet.getDouble(5);
                int stock = resultSet.getInt(6);
                int sold = resultSet.getInt(7);
                LocalDate createdDate = resultSet.getDate(8).toLocalDate();
                int status = resultSet.getInt(9);
                list.add(new Product(productId, name, description, price, discountPrice, stock, sold, createdDate, status));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

    public int updateProduct(Product inputUpdateProduct) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateProductSQL);
            preparedStatement.setString(1, inputUpdateProduct.getName());
            preparedStatement.setString(2, inputUpdateProduct.getDescription());
            preparedStatement.setDouble(3, inputUpdateProduct.getPrice());
            preparedStatement.setDouble(4, inputUpdateProduct.getDiscountPrice());
            preparedStatement.setInt(5, inputUpdateProduct.getStock());
            preparedStatement.setInt(6, inputUpdateProduct.getProductId());
            preparedStatement.executeUpdate();

            Constain.productService.updateStatus1();

            return 1;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public boolean removeProduct(int inputRemoveProduct) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.removeProductSQL);
            preparedStatement.setInt(1, inputRemoveProduct);
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean checkStock(int product_id, int quantity) {

        try(Connection connection = DbUtil.getInstance().getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.checkStockSQL);
            preparedStatement.setInt(1, product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(quantity <= resultSet.getInt(1)){
                return true;
            }

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateStockAndSold(int product_id, int quantity) {

        try(Connection connection = DbUtil.getInstance().getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateStockAndSoldSQL);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, product_id);

            preparedStatement.executeUpdate();
            Constain.productService.updateStatus0();
            return true;

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatus0() {

        try(Connection connection = DbUtil.getInstance().getConnection()){

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLCommand.updateStatus0);

            return true;

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatus1() {

        try(Connection connection = DbUtil.getInstance().getConnection()){

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLCommand.updateStatus1);

            return true;

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
       return false;
    }
}
