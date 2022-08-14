package model;

public class OrderDetail {

    private int cartId;
    private int quantity;
    private double total;
    private Order order;
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(int cartId, int quantity, double total, Order order, Product product) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.order = order;
        this.product = product;
    }

    public OrderDetail(int quantity, double total, Order order, Product product) {
        this.quantity = quantity;
        this.total = total;
        this.order = order;
        this.product = product;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
