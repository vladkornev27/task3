import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import org.example.Warehouse;

public class ConsoleDriver {
    public static void main(String[] args) throws Exception {

        System.out.println(Warehouse.class);
        PostgresConnection postgresConnection = new PostgresConnection();
        postgresConnection.execute(SQLQuaeryes.drop(Warehouse.class));

        postgresConnection.execute(SQLQuaeryes.create(Warehouse.class));


        ConsoleReader.start(postgresConnection);


        /*Warehouse warehouse = new Warehouse(111L, "adress", 222L, 333L);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(
                SQLQuaeryes.drop(warehouse.getClass())
        );

        System.out.println(SQLQuaeryes.create(warehouse.getClass()));

        System.out.println();
        System.out.println(SQLQuaeryes.insert(warehouse));
        System.out.println(SQLQuaeryes.delete(warehouse.getClass(), 11));
        System.out.println(SQLQuaeryes.update(warehouse.getClass(), 11, warehouse));


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");*/
    }
}
