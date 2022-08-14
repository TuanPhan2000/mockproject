package controller;

import model.Customer;
import service.CustomerService;
import service.serviceImpl.CustomerServiceImpl;
import util.Constain;

import java.util.List;

public class CustomerController {



    public boolean addCustomer(){

        return Constain.customerService.addCustomer(Constain.inputNewCustomer());

    }

    public boolean updateCustomer(){

        return Constain.customerService.updateCustomer(Constain.inputUpdateCustomer());

    }

    public List<Customer> getAllCustomer() {

        return Constain.customerService.getAllCustomer();

    }

    public boolean removeCustomer() {

        return Constain.customerService.removeCustomer(Constain.inputRemoveCustomer());

    }
}
