package Beans;

public class OrderDetail {
    private int id;
    private int orderid;
    private int productid;
    private int quantity;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return orderid;
    }

    public void setOrder(int order) {
        this.orderid = order;
    }

    public int getProduct() {
        return productid;
    }

    public void setProduct(int product) {
        this.productid = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
