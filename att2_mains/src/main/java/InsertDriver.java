import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InsertDriver {
    public static void main(String[] args) throws Exception {
        PostgresConnection postgresConnection = new PostgresConnection();


        postgresConnection.execute(SQLQuaeryes.drop(Customer.class));
        postgresConnection.execute(SQLQuaeryes.drop(DeliveryAddress.class));
        postgresConnection.execute(SQLQuaeryes.drop(OrderProducts.class));
        postgresConnection.execute(SQLQuaeryes.drop(Product.class));
        postgresConnection.execute(SQLQuaeryes.drop(Supplier.class));
        postgresConnection.execute(SQLQuaeryes.drop(Warehouse.class));

        postgresConnection.execute(SQLQuaeryes.create(Customer.class));
        postgresConnection.execute(SQLQuaeryes.create(DeliveryAddress.class));
        postgresConnection.execute(SQLQuaeryes.create(OrderProducts.class));
        postgresConnection.execute(SQLQuaeryes.create(Product.class));
        postgresConnection.execute(SQLQuaeryes.create(Supplier.class));
        postgresConnection.execute(SQLQuaeryes.create(Warehouse.class));


        List<OrderProducts> ordersProducts = new ObjectMapper().readValue(new FileInputStream("orderProducts.json"),
                new TypeReference<List<OrderProducts>>() {});

        for (OrderProducts o:ordersProducts) {
            postgresConnection.execute(SQLQuaeryes.insert(o));
            postgresConnection.execute(SQLQuaeryes.insert(o.getCustomer()));
            for (Product p:o.getProducts()) {
                postgresConnection.execute(SQLQuaeryes.insert(p));
                postgresConnection.execute(SQLQuaeryes.insert(p.getSupplier()));
                postgresConnection.execute(SQLQuaeryes.insert(p.getWarehouse()));
            }
            postgresConnection.execute(SQLQuaeryes.insert(o.getAddress()));
        }


    }
}
