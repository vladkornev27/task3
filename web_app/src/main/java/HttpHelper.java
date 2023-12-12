import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HttpHelper {

    public static Object readObj(HttpServletRequest request, Class table, String prefix) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        boolean isEmpty = true;
        Object object = table.newInstance();
        for (Field f:Reflection.getFields(table)) {
            String value = request.getParameter(prefix+f.getName());
            if(value.isEmpty())
                continue;

            isEmpty = false;
            Reflection.setValue(object, f.getName(), castVal(value, f.getType()));
        }

        return isEmpty ? null : object;
    }


    public static Object castVal(String val, Class type){
        if (type.equals(Integer.class) || type.equals(int.class))
            return Integer.parseInt(val);
        if (type.equals(Long.class) || type.equals(long.class))
            return Long.parseLong(val);
        return val;
    }

    public static void printResultSet(ResultSet rs, Class c, HttpServletResponse response) throws SQLException, IOException {
        List<Field> fields = Reflection.getFields(c);
        while (rs.next()){
            for (Field f:fields) {
                response.getWriter().println(
                        "%s: %s".formatted(f.getName(), rs.getObject(f.getName()))
                );
            }
            System.out.println();
        }
    }


}
