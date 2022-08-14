package main;

import controller.*;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductController productController = new ProductController();
        DiscountController discountController = new DiscountController();
        CustomerController customerController = new CustomerController();
        AddressController addressController = new AddressController();
        OrderController orderController = new OrderController();
        int n;

        do {
            System.out.println("---------------------------");
            System.out.println("1: Khách hàng");
            System.out.println("2: Sản phầm");
            System.out.println("3: Địa chỉ");
            System.out.println("4: Discount");
            System.out.println("5: Mua hàng: ");
            System.out.println("6: Đơn hàng: ");
            System.out.println("---------------------------");
            System.out.println("Nhập lựa chọn: ");
            n = scanner.nextInt();
            switch (n){
                case 1:
                    List<Customer> listCustomer = customerController.getAllCustomer();
                    System.out.println("---------------------------");
                    System.out.println("Nhập lựa chọn: ");
                    System.out.println("1: Thêm khách hàng");
                    System.out.println("2: Cập nhật khách hàng");
                    System.out.println("3: Xóa khách hàng");
                    System.out.println("4: Danh sách khách hàng");
                    switch (scanner.nextInt()){
                        case 1:
                            if(customerController.addCustomer()){
                                System.out.println("Thêm thành công");
                            }
                            else System.out.println("Thêm thất bại");
                            break;
                        case 2:
                            System.out.println("Danh sách khách hàng: ");
                            for(Customer customer : listCustomer){
                                System.out.println(customer.toString());
                            }
                            if(customerController.updateCustomer()){
                                System.out.println("Cập nhật thành công");
                            }
                            else System.out.println("Cập nhật thất bại");
                            break;
                        case 3:
                            System.out.println("Danh sách khách hàng: ");
                            for(Customer customer : listCustomer){
                                System.out.println(customer.toString());
                            }
                            if(customerController.removeCustomer()){
                                System.out.println("Xóa thành công");
                            }
                            else System.out.println("Xóa thất bại");
                            break;
                        case 4:
                            System.out.println("Danh sách khách hàng: ");
                            for(Customer customer : listCustomer){
                                System.out.println(customer.toString());
                            }
                            break;
                    }
                    break;
                case 2:
                    List<Product> listProduct = productController.getAllProducts();
                    System.out.println("---------------------------");
                    System.out.println("Nhập lựa chọn: ");
                    System.out.println("1: Thêm sản phẩm");
                    System.out.println("2: Cập nhật sản phẩm");
                    System.out.println("3: Xóa sản phẩm");
                    System.out.println("4: Danh sách sản phẩm");
                    switch (scanner.nextInt()){
                        case 1:
                            if(productController.saveProduct()){
                                System.out.println("Thêm thành công");
                            }
                            else System.out.println("Thêm thất bại");
                            break;
                        case 2:
                            System.out.println("Danh sách sản phẩm hiện tại");
                            for(Product p : listProduct){
                                System.out.println(p.toString());
                            }
                            if(productController.updateProduct() == 1){
                                System.out.println("Cập nhật thành công");
                            }
                            else System.out.println("Cập nhật thất bại");
                            break;
                        case 3:
                            System.out.println("Danh sách sản phẩm hiện tại");
                            for(Product p : listProduct){
                                System.out.println(p.toString());
                            }
                            if(productController.removeProduct()){
                                System.out.println("Xóa thành công");
                            }
                            else System.out.println("Xóa thất bại");
                            break;
                        case 4:
                            System.out.println("Danh sách sản phẩm hiện tại");
                            for(Product p : listProduct){
                                System.out.println(p.toString());
                            }
                            break;
                    }
                    break;

                case 3:
                    List<Address> listAddress = addressController.getAllAddress();
                    System.out.println("---------------------------");
                    System.out.println("Nhập lựa chọn: ");
                    System.out.println("1: Thêm địa chỉ");
                    System.out.println("2: Cập nhật địa chỉ");
                    System.out.println("3: Xóa địa chỉ");
                    System.out.println("4: Danh sách địa chỉ");
                    switch (scanner.nextInt()){
                        case 1:
                            if(addressController.addAddress() != 0){
                                System.out.println("Thêm thành công");
                            }
                            else System.out.println("Thêm thất bại");
                            break;
                        case 2:
                            System.out.println("Danh sách địa chỉ hiện tại: ");
                            for(Address address : listAddress){
                                System.out.println(address.toString());
                            }
                            if(addressController.updateAddress() == 1){
                                System.out.println("Cập nhật thành công");
                            }
                            else System.out.println("Cập nhật thất bại");
                            break;
                        case 3:
                            System.out.println("Danh sách địa chỉ hiện tại: ");
                            for(Address address : listAddress){
                                System.out.println(address.toString());
                            }
                            if(addressController.removeAddress()){
                                System.out.println("Xóa thành công");
                            } else System.out.println("Xóa thất bại");

                            break;
                        case 4:
                            System.out.println("Danh sách địa chỉ hiện tại: ");
                            for(Address address : listAddress){
                                System.out.println(address.toString());
                            }
                            break;
                    }
                    break;

                case 4:
                    List<Discount> listDiscount = discountController.getAllDiscounts();
                    System.out.println("---------------------------");
                    System.out.println("Nhập lựa chọn: ");
                    System.out.println("1: Thêm discount");
                    System.out.println("2: Cập nhật discount");
                    System.out.println("3: Xóa discount");
                    System.out.println("4: Danh sách discount");
                    switch (scanner.nextInt()){
                        case 1:
                            if(discountController.saveDiscount()){
                                System.out.println("Thêm thành công");
                            }
                            else System.out.println("Thêm thất bại");
                            break;
                        case 2:
                            System.out.println("Danh sách discount: ");
                            for(Discount d : listDiscount){
                                System.out.println(d.toString());
                            }
                            if(discountController.updateDiscount() == 1){
                                System.out.println("Cập nhật thành công");
                            }
                            else System.out.println("Cập nhật thất bại, không tìm thấy id");
                            break;
                        case 3:
                            System.out.println("Danh sách discount: ");
                            for(Discount d : listDiscount){
                                System.out.println(d.toString());
                            }
                            if(discountController.removeDiscount()){
                                System.out.println("Xóa thành công");
                            }
                            else {
                                System.out.println("Xóa thất bại, không tìm thấy id");
                            }
                            break;
                        case 4:
                            System.out.println("Danh sách discount: ");
                            for(Discount d : listDiscount){
                                System.out.println(d.toString());
                            }
                            break;
                    }
                    break;

                case 5:
                    System.out.println("---------------------------");
                    int check = orderController.addOrder();
                    if(check == 1){
                        System.out.println("Mua hàng thành công");
                    }
                    if(check == 0){
                        System.out.println("Mua hàng thất bại");
                    }
                    break;

                case 6:
                    List<Order> listOrder = orderController.getAllOrders();
                    System.out.println("---------------------------");
                    System.out.println("Nhập lựa chọn: ");
                    System.out.println("1: Xem đơn hàng");
                    System.out.println("2: Cập nhật đơn hàng");
                    System.out.println("3: Xóa đơn hàng");
                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println("Danh sách các đơn hàng: ");
                            for (Order order : listOrder){
                                System.out.println(order);
                            }
                            break;
                        case 2:
                            System.out.println("Danh sách các đơn hàng: ");
                            for (Order order : listOrder){
                                System.out.println(order);
                            }
                            if(orderController.updateOrder()){
                                System.out.println("Cập nhật thành công");
                            } else System.out.println("Cập nhật thất bại");
                            break;
                        case 3:
                            System.out.println("Danh sách các đơn hàng: ");
                            for (Order order : listOrder){
                                System.out.println(order);
                            }
                            if( orderController.removeOrder()){
                                System.out.println("Xoá thành công");
                            } else System.out.println("Xóa thất bại");
                            break;

                    }
                    break;
            }
        } while (n != 0);

    }

}
