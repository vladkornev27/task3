import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.*;

import java.util.List;

public class ServerContainer {
    private static final int PORT = 8080;
    private PostgresConnection connection;

    public ServerContainer(PostgresConnection connection) {
        this.connection = connection;
    }

    public void serverDrive() throws Exception {

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");


        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                Customer.class
                        )
                ),
                "/Customer"
        );


        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                DeliveryAddress.class
                        )
                ),
                "/DeliveryAddress"
        );

        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                OrderProducts.class
                        )
                ),
                "/OrderProducts"
        );

        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                OrderProducts.class
                        )
                ),
                "/OrderProducts"
        );

        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                Product.class
                        )
                ),
                "/Product"
        );

        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                Supplier.class
                        )
                ),
                "/Supplier"
        );

        context.addServlet(
                new ServletHolder(
                        new Servlet(
                                connection,
                                Warehouse.class
                        )
                ),
                "/Warehouse"
        );

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { context });
        server.setHandler(handlers);
        server.start();
        server.join();
    }


}