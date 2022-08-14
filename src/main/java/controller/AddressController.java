package controller;

import model.Address;

import util.Constain;

import java.util.List;

public class AddressController {



   public int addAddress(){
      return Constain.addressService.addAddress(Constain.inputNewAddress());
   }

   public int updateAddress(){
      return Constain.addressService.updateAddress(Constain.inputUpdateAddress());
   }

   public List<Address>  getAllAddress(){
      return Constain.addressService.getAllAddress();
   }

   public boolean removeAddress(){
      return Constain.addressService.removeAddress(Constain.inputRemoveAddress());
   }

}
