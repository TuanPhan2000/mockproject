package dao;

import model.Address;
import service.CustomerService;
import service.serviceImpl.CustomerServiceImpl;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {


    public AddressDAO() {
    }


    public List<Address> findAddressByPostalCode(String postalCode) {

        List<Address> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.findAddressByPostalCode);
            preparedStatement.setString(1, postalCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int addressId = resultSet.getInt(1);
                String city = resultSet.getString(2);
                String district = resultSet.getString(3);
                String subDistrict = resultSet.getString(4);
                double deliveryFee = resultSet.getDouble(6);
                list.add(new Address(addressId, city, district, subDistrict, postalCode, deliveryFee));
            }

        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }

        return list;
    }

    public static int addAddress(Address address) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.insertAddressSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getDistrict());
            preparedStatement.setString(3, address.getSubDistrict());
            preparedStatement.setString(4, address.getPostalCode());
            preparedStatement.setDouble(5, address.getDeliveryFee());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public Address findAddressById(int addressId) {

        Address address = new Address();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.findAddressById);
            preparedStatement.setInt(1, addressId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                address.setAddressId(resultSet.getInt(1));
                address.setCity(resultSet.getString(2));
                address.setDistrict(resultSet.getString(3));
                address.setSubDistrict(resultSet.getString(4));
                address.setPostalCode(resultSet.getString(5));
                address.setDeliveryFee(resultSet.getDouble(6));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return address;

    }

    public int updateAddress(Address inputUpdateAddress) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateAddressSQL);
            preparedStatement.setString(1, inputUpdateAddress.getCity());
            preparedStatement.setString(2, inputUpdateAddress.getDistrict());
            preparedStatement.setString(3, inputUpdateAddress.getSubDistrict());
            preparedStatement.setString(4, inputUpdateAddress.getPostalCode());
            preparedStatement.setDouble(5, inputUpdateAddress.getDeliveryFee());
            preparedStatement.setInt(6, inputUpdateAddress.getAddressId());

            preparedStatement.executeUpdate();
            return 1;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public List<Address> getAllAddress() {

        List<Address> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.getAllAddressSQL);
            while(resultSet.next()){
                list.add(new Address(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDouble(6)));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean removeAddress(int inputRemoveAddress) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {
            Constain.customerService.updateAddressIdIsNull(inputRemoveAddress);
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.removeAddressSQL);
            preparedStatement.setInt(1, inputRemoveAddress);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
