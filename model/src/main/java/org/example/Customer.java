package org.example;




public class Customer {
    private Long id;
    private String name;
    private String mail;

    private Long orderId;

    public Customer() {
    }

    public Customer(Long id, String name, String mail, Long orderId) {
        this.id = id;
        this.name = name;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
