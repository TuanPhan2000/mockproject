package dao;

import model.Customer;
import service.AddressService;
import service.serviceImpl.AddressServiceImpl;
import util.Constain;
import util.DbUtil;
import util.SQLCommand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {



    public CustomerDAO() {
    }

    public boolean addCustomer(Customer inputNewCustomer) {
        try(Connection connection = DbUtil.getInstance().getConnection()) {

            if(inputNewCustomer.getAddress().getAddressId() == 0){
                inputNewCustomer.getAddress().setAddressId(Constain.addressService.addAddress(inputNewCustomer.getAddress()));
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.insertCustomerSQL);
            preparedStatement.setString(1, inputNewCustomer.getFullName());
            preparedStatement.setString(2, inputNewCustomer.getEmail());
            preparedStatement.setString(3, inputNewCustomer.getPhoneNumber());
            preparedStatement.setInt(4, inputNewCustomer.getAddress().getAddressId());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCustomer(Customer inputUpdateCustomer) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            if(inputUpdateCustomer.getAddress().getAddressId() == 0){
                inputUpdateCustomer.getAddress().setAddressId(Constain.addressService.addAddress(inputUpdateCustomer.getAddress()));
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateCustomerSQL);
            preparedStatement.setString(1, inputUpdateCustomer.getFullName());
            preparedStatement.setString(2, inputUpdateCustomer.getEmail());
            preparedStatement.setString(3, inputUpdateCustomer.getPhoneNumber());
            preparedStatement.setInt(4, inputUpdateCustomer.getAddress().getAddressId());
            preparedStatement.setInt(5, inputUpdateCustomer.getCustomerId());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public List<Customer> getAllCustomer() {

        List<Customer> list = new ArrayList<>();

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLCommand.getAllCustomerSQL);
            while (resultSet.next()){
                int customerId = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phoneNumber = resultSet.getString(4);
                int addressId = resultSet.getInt(5);
                list.add(new Customer(customerId, fullName, email, phoneNumber, Constain.addressService.findAddressById(addressId)));
            }

        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }

        return list;

    }

    public boolean removeCustomer(int inputRemoveCustomer) {

        try(Connection connection = DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.removeCustomerSQL);
            preparedStatement.setInt(1, inputRemoveCustomer);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updateAddressIdIsNull(int inputAddressId) {

        try(Connection connection =DbUtil.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.updateAddressIdNullSQL);
            preparedStatement.setInt(1, inputAddressId);
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public Customer findCustomerById(int customerId) {

        try (Connection connection = DbUtil.getInstance().getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand.selectCustomerByIdSQL);
            preparedStatement.setInt(1, customerId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), Constain.addressService.findAddressById(resultSet.getInt(5)));

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Customer();
    }
}
