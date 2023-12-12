import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SQLHelper {

    public static String toSqlType(Class fieldType){
        if (fieldType.equals(Long.class) || fieldType.equals(long.class))
            return "BIGINT";
        else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)){
            return "INT";
        } else if (fieldType.equals(String.class)) {
            return String.format("VARCHAR(%d)", 255);
        }
        return null;
    }

    public static String toSqlCreateColumn(String fieldName, Class fieldType, Class c){
        return " %s %s %s ".formatted(
                fieldName,
                toSqlType(fieldType),
                isPrimaryKey(fieldName, c) ? "PRIMARY KEY" : ""
        );
    }

    public static String toSqlInsertCollumn(String fieldName, Class fieldType, Class c){
        return " %s %s %s ".formatted(
                fieldName,
                toSqlType(fieldType),
                isPrimaryKey(fieldName, c) ? "PRIMARY KEY" : ""
        );
    }

    public static String toSqlValue(Object o){
        return o.getClass().equals(String.class) ? "\'%s\'".formatted(o) : o.toString();
    }
    public static boolean isPrimaryKey(String fieldName, Class c){
        return Set.of(
                (c.getSimpleName()+"id").toLowerCase(), "id"
        ).contains(fieldName.toLowerCase());

    }

    public static Map<String, Object> getFilledValues(Object o) throws Exception {
        List<Field> fields = Reflection.getFields(o.getClass());

        Map<String, Object> values = new HashMap<>();

        for (Field f:fields) {
            String fn = f.getName();
            Object val = Reflection.getValue(o, fn);
            if(val == null)
                continue;
            values.put(fn, val);
        }
        return values;
    }
}
