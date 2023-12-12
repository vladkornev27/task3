package org.example;





public class Supplier {
    private Long id;
    private String name;

    private Long productId;
    private Long orderId;

    public Supplier() {
    }

    public Supplier(Long id, String name, Long productId, Long orderId) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
