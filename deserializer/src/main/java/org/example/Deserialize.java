package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Deserialize {
    public static void readFromJson () throws IOException {

        List<OrderProducts> ordersProducts = new ObjectMapper().readValue(new FileInputStream("orderProducts.json"),
                new TypeReference<List<OrderProducts>>() {});

        for (OrderProducts o : ordersProducts) {
            System.out.println(o.getId());
            System.out.println(o.getTotal());
            System.out.println(o.getOrderStatus());
            System.out.println(o.getCustomer());
            System.out.println(o.getProducts());
            System.out.println(o.getAddress());
            System.out.println("____________________________");
        }
    }
}
