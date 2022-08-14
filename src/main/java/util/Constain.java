package util;

import model.*;
import service.*;
import service.serviceImpl.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Constain {
    public static final DiscountService discountService = new DiscountServiceImpl();

    public static final ProductService productService = new ProductServiceImpl();

    public static final AddressService addressService = new AddressServiceImpl();
    public static final CustomerService customerService = new CustomerServiceImpl();

    public static final OrderService orderService = new OrderServiceImpl();
    public static final OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    public static Map<Integer, Integer> mapDetailOrder = new HashMap<>();

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^\\d{4}-\\d{2}-\\d{2}$");

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_NUMBER =
            Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})", Pattern.CASE_INSENSITIVE);

    public static  Product inputNewProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mô tả: ");
        String description = scanner.nextLine();
        boolean checkPrice = false;
        double price = 0;
        while(!checkPrice){
            System.out.println("Nhập giá sản phẩm: ");
            if(scanner.hasNextDouble()){
                checkPrice = true;
                price = scanner.nextDouble();
            }
            else System.out.println("Giá sản phẩm có kiểu dữ liệu double");
            scanner.nextLine();
        }
        boolean checkDiscountPrice = false;
        double discountPrice = 0;
        while(!checkDiscountPrice){
            System.out.println("Nhập discount price: ");
            if(scanner.hasNextDouble()){
                checkDiscountPrice = true;
                discountPrice = scanner.nextDouble();
            }
            else System.out.println("Discount price có kiểu dữ liệu double");
            scanner.nextLine();
        }
        boolean checkStock = false;
        int stock = 0;
        while(!checkStock){
            System.out.println("Nhập số lượng: ");
            if(scanner.hasNextInt()){
                checkStock = true;
                stock = scanner.nextInt();
            }
            else System.out.println("Stock có kiểu dữ liệu double");
            scanner.nextLine();
        }
        LocalDate createDate = java.time.LocalDate.now();
        return new Product(name, description, price, discountPrice, stock, createDate);
    }

    public static Product inputUpdateProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần cập nhật: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mô tả: ");
        String description = scanner.nextLine();
        boolean checkPrice = false;
        double price = 0;
        while(!checkPrice){
            System.out.println("Nhập giá sản phẩm: ");
            if(scanner.hasNextDouble()){
                checkPrice = true;
                price = scanner.nextDouble();
            }
            else System.out.println("Giá sản phẩm có kiểu dữ liệu double");
            scanner.nextLine();
        }
        boolean checkDiscountPrice = false;
        double discountPrice = 0;
        while(!checkDiscountPrice){
            System.out.println("Nhập discount price: ");
            if(scanner.hasNextDouble()){
                checkDiscountPrice = true;
                discountPrice = scanner.nextDouble();
            }
            else System.out.println("Discount price có kiểu dữ liệu double");
            scanner.nextLine();
        }
        boolean checkStock = false;
        int stock = 0;
        while(!checkStock){
            System.out.println("Nhập số lượng: ");
            if(scanner.hasNextInt()){
                checkStock = true;
                stock = scanner.nextInt();
            }
            else System.out.println("Stock có kiểu dữ liệu double");
            scanner.nextLine();
        }
        return new Product(productId, name, description, price, discountPrice, stock);
    }

    public static int inputRemoveProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm muốn xóa: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        return productId;
    }

    public static Discount inputNewDiscount() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập title discount: ");
        String title = scanner.nextLine();
        int type = 0;
        boolean checkType = false;
        while (!checkType){
            System.out.println("Nhập type discount:");
            System.out.println("1: Giảm %");
            System.out.println("2: Giảm trực tiếp giá tiền: ");
            if(scanner.hasNextInt()){
                type = scanner.nextInt();
                if(type >= 1 && type <= 2){
                    checkType = true;
                }
            }
            else System.out.println("Nhập lại");
            scanner.nextLine();
        }
        double discount = 0.0;
        boolean checkDiscount = false;
        while (!checkDiscount){
            System.out.println("Nhập discount:");
            if(scanner.hasNextDouble()){
                discount = scanner.nextDouble();
                checkDiscount = true;
            }
            else System.out.println("Discount kiểu double");
            scanner.nextLine();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = null;
        boolean checkStartDate = false;
        while(!checkStartDate){
            String start = null;
            System.out.println("Nhập start date: ");
            if(DATE_PATTERN.matcher((start = scanner.nextLine())).matches()){
                startDate = LocalDate.parse(start, formatter);
                checkStartDate = true;
            }
            else System.out.println("Định dạng yyyy-MM-dd");
        }

        LocalDate endDate = null;
        boolean checkEndDate = false;
        while(!checkEndDate){
            String end = null;
            System.out.println("Nhập end date: ");
            if(DATE_PATTERN.matcher((end = scanner.nextLine())).matches()){
                endDate = LocalDate.parse(end, formatter);
                checkEndDate = true;
            }
            else System.out.println("Định dạng yyyy-MM-dd");
        }

        return new Discount(title, type, discount, startDate, endDate);

    }

    public static Discount inputUpdateDiscount() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id discount cần cập nhật: ");
        int discountId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập title discount: ");
        String title = scanner.nextLine();
        int type = 0;
        boolean checkType = false;
        while (!checkType){
            System.out.println("Nhập type discount:");
            System.out.println("1: Giảm %");
            System.out.println("2: Giảm trực tiếp giá tiền: ");
            if(scanner.hasNextInt()){
                type = scanner.nextInt();
                if(type >= 1 && type <= 2){
                    checkType = true;
                }
            }
            else System.out.println("Nhập lại");
            scanner.nextLine();
        }
        double discount = 0.0;
        boolean checkDiscount = false;
        while (!checkDiscount){
            System.out.println("Nhập discount:");
            if(scanner.hasNextDouble()){
                discount = scanner.nextDouble();
                checkDiscount = true;
            }
            else System.out.println("Discount kiểu double");
            scanner.nextLine();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = null;
        boolean checkStartDate = false;
        while(!checkStartDate){
            String start = null;
            System.out.println("Nhập start date: ");
            if(DATE_PATTERN.matcher((start = scanner.nextLine())).matches()){
                startDate = LocalDate.parse(start, formatter);
                checkStartDate = true;
            }
            else System.out.println("Định dạng yyyy-MM-dd");
        }

        LocalDate endDate = null;
        boolean checkEndDate = false;
        while(!checkEndDate){
            String end = null;
            System.out.println("Nhập end date: ");
            if(DATE_PATTERN.matcher((end = scanner.nextLine())).matches()){
                endDate = LocalDate.parse(end, formatter);
                checkEndDate = true;
            }
            else System.out.println("Định dạng yyyy-MM-dd");
        }

        return new Discount(discountId, title, type, discount, startDate, endDate);

    }

    public static int inputRemoveDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id discount muốn xóa: ");
        int discountId = scanner.nextInt();
        scanner.nextLine();
        return discountId;
    }

    public static Customer inputNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = null;
        while (!Validator.validateEmail((email = scanner.nextLine()))){
            System.out.println("Nhập lại email, sai định dạng");
        }
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (!Validator.validatePhoneNumber((phoneNumber = scanner.nextLine()))){
            System.out.println("Nhập lại số điện thoại, sai định dạng");
        }
        System.out.println("Nhập city: ");
        String city = scanner.nextLine();
        System.out.println("Nhập district: ");
        String district = scanner.nextLine();
        System.out.println("Nhập sub-district: ");
        String subDistrict = scanner.nextLine();
        System.out.println("Nhập postal_code: ");
        String postalCode = scanner.nextLine();
        double deleveryFee = 0.0;
        List<Address> listAddress = addressService.findAddressByPostalCode(postalCode);
        if(listAddress.size() > 0){
            for(Address a : listAddress){
                if(a.getSubDistrict().equals(subDistrict)){
                    return new Customer(fullName, email, phoneNumber, a);
                }
            }
            deleveryFee = listAddress.get(0).getDeliveryFee();
        }
        else{
            System.out.println("Nhập phí ship: ");
            deleveryFee = scanner.nextDouble();
        }
        return new Customer(fullName, email, phoneNumber, new Address(city, district, subDistrict, postalCode, deleveryFee));

    }

    public static Customer inputUpdateCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id customer cần update: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = null;
        while (!Validator.validateEmail((email = scanner.nextLine()))){
            System.out.println("Nhập lại email, sai định dạng");
        }
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (!Validator.validatePhoneNumber((phoneNumber = scanner.nextLine()))){
            System.out.println("Nhập lại số điện thoại, sai định dạng");
        }
        System.out.println("Nhập city: ");
        String city = scanner.nextLine();
        System.out.println("Nhập district: ");
        String district = scanner.nextLine();
        System.out.println("Nhập sub-district: ");
        String subDistrict = scanner.nextLine();
        System.out.println("Nhập postal_code: ");
        String postalCode = scanner.nextLine();
        double deleveryFee = 0.0;
        List<Address> listAddress = addressService.findAddressByPostalCode(postalCode);
        if(listAddress.size() > 0){
            for(Address a : listAddress){
                if(a.getSubDistrict().equals(subDistrict)){
                    return new Customer(customerId,fullName, email, phoneNumber, a);
                }
            }
            deleveryFee = listAddress.get(0).getDeliveryFee();
        }
        else{
            System.out.println("Nhập phí ship: ");
            deleveryFee = scanner.nextDouble();
        }
        return new Customer(customerId, fullName, email, phoneNumber, new Address(city, district, subDistrict, postalCode, deleveryFee));

    }

    public static int inputRemoveCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng muốn xóa: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        return customerId;
    }

    public static Address inputNewAddress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập city: ");
        String city = scanner.nextLine();
        System.out.println("Nhập district: ");
        String district = scanner.nextLine();
        System.out.println("Nhập sub district: ");
        String subDistrict = scanner.nextLine();
        System.out.println("Nhập postal code: ");
        String postalCode = scanner.nextLine();
        List<Address> list = addressService.findAddressByPostalCode(postalCode);
        if(list.size() > 0 ){
            for(Address a : list){
                if(a.getSubDistrict().equals(subDistrict)){
                    System.out.println("Đã tồn tại địa chỉ, vui lòng nhập lại");
                    return inputNewAddress();
                }
            }
        }
        System.out.println("Nhập phí ship(double): ");
        double deliveryFee = scanner.nextDouble();
        return new Address(city, district, subDistrict, postalCode, deliveryFee);
    }

    public static Address inputUpdateAddress() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id địa chỉ cần cập nhật: ");
        int addressId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập city: ");
        String city = scanner.nextLine();
        System.out.println("Nhập district: ");
        String district = scanner.nextLine();
        System.out.println("Nhập sub district: ");
        String subDistrict = scanner.nextLine();
        System.out.println("Nhập postal code: ");
        String postalCode = scanner.nextLine();
        System.out.println("Nhập phí ship(double): ");
        double deliveryFee = scanner.nextDouble();
        return new Address(addressId, city, district, subDistrict, postalCode, deliveryFee);

    }

    public static int inputRemoveAddress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id địa chỉ muốn xóa: ");
        int addressId = scanner.nextInt();
        scanner.nextLine();
        return addressId;
    }

    public static Order inputAddOrder(){
        Scanner scanner = new Scanner(System.in);
        List<Product> listProduct = productService.getAllProducts();
        System.out.println("Danh sách sản phẩm: ");
        for(Product product : listProduct){
            System.out.println(product);
        }
        boolean checkStop = false;
        while(!checkStop){
            System.out.println("Nhập id sản phẩm cần order: ");
            int product_id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập số lượng của sản phẩm cần order: ");
            int quantity =scanner.nextInt();
            scanner.nextLine();
            if(!productService.checkStock(product_id, quantity)){
                System.out.println("Hết sản phẩm");
                System.out.println(" Y để chọn sản phẩm khác, N để hủy mua hàng, nút khác để tiến hành thanh toán: ");
                String check = scanner.nextLine();
                if(check.equals("N")){
                   return null;
                }
                if(check.equals("Y")){
                    return inputAddOrder();
                }


            }
           if(productService.checkStock(product_id, quantity)){
               mapDetailOrder.put(product_id, quantity);
           }
            System.out.println("Thanh toán ? Y để xác nhận, N để thêm sản phẩm");
            if(scanner.nextLine().equals("Y")){
                checkStop = true;
            }
        }

        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (!Validator.validatePhoneNumber((phoneNumber = scanner.nextLine()))){
            System.out.println("Nhập lại số điện thoại, sai định dạng");
        }

        System.out.println("Nhập city ship đến: ");
        String city = scanner.nextLine();
        System.out.println("Nhập quận/huyện: ");
        String district = scanner.nextLine();
        System.out.println("Nhập xã/phường: ");
        String subDistrict = scanner.nextLine();
        System.out.println("Nhập chi tiết số nhà/thôn: ");
        String detailAddress = scanner.nextLine();
        System.out.println("Nhập postal code: ");
        String postalCode = scanner.nextLine();
        double deleveryFee = 0.0;
        Address address = new Address();
        List<Address> listAddress = addressService.findAddressByPostalCode(postalCode);
        if(listAddress.size() > 0){
            boolean check = false;
            for(Address a : listAddress){
                if(a.getSubDistrict().equals(subDistrict)){
                    check = true;
                    address = a;
                    break;
                }
            }
            if(!check){
                deleveryFee = listAddress.get(0).getDeliveryFee();
                address = new Address(city, district, subDistrict, postalCode, deleveryFee);
            }
        }
        else{
            System.out.println("Nhập phí ship: ");
            deleveryFee = scanner.nextDouble();
            scanner.nextLine();
            address = new Address(city, district, subDistrict, postalCode, deleveryFee);
        }
        Customer customer = new Customer();
        System.out.println("Danh sách khách hàng: ");
        List<Customer> listCustomer = customerService.getAllCustomer();
        for(Customer c1 : listCustomer){
            System.out.println(c1);
        }
        System.out.println("Nhập id khách hàng cần order: ");
        int idCustomer = scanner.nextInt();
        scanner.nextLine();
        for(Customer c2 : listCustomer){
            if(c2.getCustomerId() == idCustomer){
                customer = c2;
                break;
            }
        }
        double total = 0.0;
        Set<Integer> set = mapDetailOrder.keySet();
        for (Integer key : set){
            Product product = listProduct.stream().filter(product1 -> key == product1.getProductId()).findFirst().orElse(null);
            total += (product.getPrice() - product.getDiscountPrice()) * mapDetailOrder.get(key);
        }
        System.out.println("Bạn có muốn thêm discount vào order ? Y để thêm, N để bỏ qua");
        if(scanner.nextLine().equals("Y")){
         return addDiscountToOrder(name, phoneNumber, detailAddress, total, customer, address);
        }


        return new Order(name, phoneNumber, detailAddress, total, LocalDate.now(), customer, address);

    }

    private static Order addDiscountToOrder(String name, String phoneNumber, String detailAddress, double total, Customer customer, Address address){
        Scanner scanner = new Scanner(System.in);
        Discount discount = null;
        System.out.println("Danh sách discount: ");
        List<Discount> listDiscount= discountService.getAllDiscounts();
        for(Discount d1 : listDiscount){
            System.out.println(d1);
        }
        System.out.println("Nhập id discount cần add vào order: ");
        int discountId = scanner.nextInt();
        scanner.nextLine();
        for(Discount d2 : listDiscount){
            if(d2.getDiscountId() == discountId){
                if(d2.getStartDate().isBefore(LocalDate.now()) && d2.getEndDate().isAfter(LocalDate.now())){
                    discount = d2;
                    break;
                }
            }
        }

        if(discount != null){
            if(discount.getType() == 1 ){
                total = total - (total * discount.getDiscount()) + address.getDeliveryFee();
            }
            else {
                total = total - discount.getDiscount() + address.getDeliveryFee();
            }
            return new Order(name, phoneNumber, detailAddress, total, LocalDate.now(), customer, address, discount);
        }
        else{
            System.out.println("Discount không thể áp dụng, bạn có muốn bỏ qua ? Y để bỏ qua, nút bất kì để chọn discount khác ");
            if(!scanner.nextLine().equals("Y")){
               return addDiscountToOrder(name, phoneNumber, detailAddress, total, customer, address);
            }

        }
        return new Order(name, phoneNumber, detailAddress, total, LocalDate.now(), customer, address);
    }
}
