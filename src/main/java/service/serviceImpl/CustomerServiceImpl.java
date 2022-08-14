package service.serviceImpl;

import dao.CustomerDAO;
import model.Customer;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    public boolean addCustomer(Customer inputNewCustomer) {
        return customerDAO.addCustomer(inputNewCustomer);
    }

    @Override
    public boolean updateCustomer(Customer inputUpdateCustomer) {
        return customerDAO.updateCustomer(inputUpdateCustomer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDAO.getAllCustomer();
    }

    @Override
    public boolean removeCustomer(int inputRemoveCustomer) {
        return customerDAO.removeCustomer(inputRemoveCustomer);
    }

    @Override
    public int updateAddressIdIsNull(int inputAddressId) {
        return customerDAO.updateAddressIdIsNull(inputAddressId);
    }

    @Override
    public Customer findCustomerById(int customerId) {
        return customerDAO.findCustomerById(customerId);
    }
}
