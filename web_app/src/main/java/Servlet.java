import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private PostgresConnection connection;
    private Class table;

    public Servlet(PostgresConnection connection, Class table) {
        this.connection = connection;
        this.table = table;
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("Id"));
        ResultSet resultSet;

        if(id == null)
            resultSet = connection.executeQuaery(
                    SQLQuaeryes.find(table)
            );
        else
            resultSet = connection.executeQuaery(
                    SQLQuaeryes.find(table, id)
            );

        HttpHelper.printResultSet(resultSet, table, response);
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object object = HttpHelper.readObj(request, table, "_");
        connection.execute(
                SQLQuaeryes.insert(object)
        );
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("Id"));

        connection.execute(
                SQLQuaeryes.delete(table, id)
        );
    }
    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("Id"));
        Object object = HttpHelper.readObj(request, table, "_");
        connection.execute(
                SQLQuaeryes.update(table, id, object)
        );
    }


}
