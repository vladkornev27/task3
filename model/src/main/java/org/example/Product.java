package org.example;






public class Product {
    private Long id;
    private Long orderId;
    private String name;
    private Integer price;
    private Supplier supplier;
    private Warehouse warehouse;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                ", warehouse=" + warehouse +
                '}';
    }
}
