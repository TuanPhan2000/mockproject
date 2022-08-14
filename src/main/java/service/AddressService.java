package service;

import model.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByPostalCode(String postalCode);
    int addAddress(Address address);

    Address findAddressById(int addressId);

    int updateAddress(Address inputUpdateAddress);

    List<Address> getAllAddress();

    boolean removeAddress(int inputRemoveAddress);
}
