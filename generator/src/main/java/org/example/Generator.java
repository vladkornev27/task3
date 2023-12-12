package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Generator {
    public static List<OrderProducts> generating(long count) {


        List<OrderProducts> ordersProducts = new ArrayList<>();


        for (long i = 0; i < count; i++) {
            OrderProducts orderProduct = new OrderProducts();
            orderProduct.setId(i);
            orderProduct.setTotal(new Random().nextInt());
            orderProduct.setOrderStatus("STATUS");

            Customer customer = new Customer();
            customer.setId((i+1)*1000);
            customer.setName("CUSTOMER");
            customer.setMail("MAIL@MAIL.RU");
            customer.setOrderId(i);

            orderProduct.setCustomer(customer);

            Product product = new Product();
            product.setId((i+1)*1000);
            product.setOrderId(orderProduct.getId());
            product.setName("NAME");
            product.setPrice(Math.abs(new Random().nextInt()));

            Supplier supplier = new Supplier();
            supplier.setId((i+1)*1000);
            supplier.setName("SUPPLIER");
            supplier.setProductId(product.getId());
            supplier.setOrderId(orderProduct.getId());

            product.setSupplier(supplier);

            Warehouse warehouse = new Warehouse();
            warehouse.setId((i+1)*1000);
            warehouse.setAddress("ADDRESS");
            warehouse.setProductId(product.getId());
            warehouse.setOrderId(orderProduct.getId());

            product.setWarehouse(warehouse);

            orderProduct.setProducts(List.of(product));

            DeliveryAddress deliveryAddress = new DeliveryAddress();
            deliveryAddress.setId(i);
            deliveryAddress.setAddress("ADDRESS");
            deliveryAddress.setOrderId(orderProduct.getId());

            orderProduct.setAddress(deliveryAddress);

            ordersProducts.add(orderProduct);
        }

        return ordersProducts;
    }
}
