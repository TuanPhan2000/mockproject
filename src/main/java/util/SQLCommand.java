package util;


public class SQLCommand {

//    Product

    public static final String insertProductSQL = "INSERT INTO product(name, description, price, discount_price, stock, create_date) VALUES(?,?,?,?,?,?)";

    public static final String getAllProductsSQL = "SELECT * FROM product";

    public static final String updateProductSQL = "UPDATE product SET name = ?, description = ?,price = ?, discount_price = ?, stock = ? WHERE product_id = ?";


    public static final String removeProductSQL = "DELETE FROM product WHERE product_id = ?";

    public static final String checkStockSQL = "SELECT stock FROM product WHERE product_id = ?";

    public static final String updateStockAndSoldSQL = "UPDATE product SET stock =  stock - ?, sold = sold + ? WHERE product_id = ?";



    public static final String updateStatus0 = "UPDATE product SET status = 0 WHERE stock = 0";

    public static final String updateStatus1 = "UPDATE product SET status = 1 WHERE stock <> 0";



//    Discount
    public static final String insertDiscountSQL = "INSERT INTO discount(title, type, discount, start_date, end_date) VALUES(?,?,?,?,?)";
    public static final String getAllDiscountsSQL = "SELECT * FROM discount";
    public static final String updateDiscountSQL = "UPDATE discount SET title = ?, type = ?,discount = ?, start_date = ?, end_date = ? WHERE discount_id = ?";

    public static final String removeDiscountSQL = "DELETE FROM discount WHERE discount_id = ?";

    public static final String selectDiscountByIdSQL = "SELECT * FROM discount WHERE discount_id = ?";

    //Address
    public static final String findAddressByPostalCode = "SELECT * FROM address WHERE postal_code = ?";

    public static final String insertAddressSQL = "INSERT INTO address(city, district, sub_district, postal_code, delivery_fee) VALUES(?,?,?,?,?)";

    public static final String findAddressById = "SELECT * FROM address WHERE address_id = ?";

    public static final String updateAddressSQL = "UPDATE address SET city = ?, district = ?, sub_district = ?, postal_code = ? , delivery_fee = ? WHERE address_id = ?";


    public static final String getAllAddressSQL = "SELECT * FROM address";

    public static final String removeAddressSQL = "DELETE FROM address WHERE address_id = ?";

    //Customer

    public static final String insertCustomerSQL = "INSERT INTO customer(full_name, email, phone_number, address_id) VALUES(?,?,?,?)" ;
    public static final String updateCustomerSQL = "UPDATE customer SET full_name = ?, email = ?, phone_number = ?, address_id = ? WHERE customer_id = ?";
    public static final String selectCustomerByIdSQL = "SELECT * FROM customer WHERE customer_id = ?";

    public static final String getAllCustomerSQL = "SELECT * FROM customer";

    public static final String removeCustomerSQL = "DELETE FROM customer WHERE customer_id = ?";

    public static final String updateAddressIdNullSQL = "UPDATE customer SET address_id = null WHERE address_id = ?";

    //Order

    public static final String insertOrderSQL = "INSERT INTO mockproject.order(name, phone_number, detail_address, total, order_date, customer_id, address_id, discount_id) VALUES(?,?,?,?,?,?,?,?)";

    public static final String insertOrderNoDiscountSQL = "INSERT INTO mockproject.order(name, phone_number, detail_address, total, order_date, customer_id, address_id) VALUES(?,?,?,?,?,?,?)";

    public static final String getAllOrderSQL = "SELECT * FROM mockproject.order";

    public static final String updateOrderSQL = "UPDATE mockproject.order SET name = ?, phone_number = ?, detail_address = ? WHERE order_id = ?";
    //OrderDetail

    public static final String insertOrderDetailSQL = "INSERT INTO mockproject.order_detail(quantity, total, order_id, product_id) VALUES(?,?,?,?)";
    public static final String removeOrderDetailByOrderIdSQL = "DELETE FROM mockproject.order_detail WHERE order_id = ?";


    public static final String removeOrderById = "DELETE FROM mockproject.order WHERE order_id = ?";
}
