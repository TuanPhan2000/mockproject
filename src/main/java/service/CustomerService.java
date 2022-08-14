package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer inputNewCustomer);

    boolean updateCustomer(Customer inputUpdateCustomer);

    List<Customer> getAllCustomer();

    boolean removeCustomer(int inputRemoveCustomer);

    int updateAddressIdIsNull(int inputAddressId);

    Customer findCustomerById(int customerId);

}
