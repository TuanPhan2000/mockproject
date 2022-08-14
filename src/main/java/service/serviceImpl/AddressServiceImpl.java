package service.serviceImpl;

import dao.AddressDAO;
import model.Address;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

     AddressDAO addressDAO = new AddressDAO();


    @Override
    public List<Address> findAddressByPostalCode(String postalCode) {
        return addressDAO.findAddressByPostalCode(postalCode);
    }

    @Override
    public int addAddress(Address address) {

        return addressDAO.addAddress(address);
    }

    @Override
    public Address findAddressById(int addressId) {
        return addressDAO.findAddressById(addressId);
    }

    @Override
    public int updateAddress(Address inputUpdateAddress) {
        return addressDAO.updateAddress(inputUpdateAddress);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressDAO.getAllAddress();
    }

    @Override
    public boolean removeAddress(int inputRemoveAddress) {
        return addressDAO.removeAddress(inputRemoveAddress);
    }
}
