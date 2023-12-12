package org.example;



import java.util.List;


public class OrderProducts {
    private Long id;
    private Integer total;
    private String orderStatus;
    private Customer customer;

    private List<Product> products;
    private DeliveryAddress address;

    public OrderProducts() {
    }

    public OrderProducts(Long id, Integer total, String orderStatus, Customer customer, List<Product> products, DeliveryAddress address) {
        this.id = id;
        this.total = total;
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.products = products;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DeliveryAddress getAddress() {
        return address;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderProducts{" +
                "id=" + id +
                ", total=" + total +
                ", orderStatus='" + orderStatus + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", address=" + address +
                '}';
    }
}
