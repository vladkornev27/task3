import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SQLQuaeryes {
    public static String create(Class tableName){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(
                "CREATE TABLE IF NOT EXISTS %s ( ".formatted(tableName.getSimpleName())
        );

        List<Field> columns = Reflection.getFields(tableName);

        String fieldName = columns.get(0).getName();
        Class fieldType = columns.get(0).getType();

        String bufferString = SQLHelper.toSqlCreateColumn(fieldName, fieldType, tableName);
        for (int i = 1; i < columns.size(); i++) {
            stringBuilder.append(bufferString).append(" , ");
            fieldName = columns.get(i).getName();
            fieldType = columns.get(i).getType();

            bufferString = SQLHelper.toSqlCreateColumn(fieldName, fieldType, tableName);
        }
        stringBuilder.append(bufferString).append(" );");

        return stringBuilder.toString();
    }




    public static String drop(Class table){
        return drop(table.getSimpleName());
    }
    public static String drop(String table){
        return "DROP TABLE IF EXISTS %s;".formatted(table);
    }




    public static String insert(Object o) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(
                "INSERT INTO %s VALUES ( ".formatted(o.getClass().getSimpleName())
        );

        List<Field> columns = Reflection.getFields(o.getClass());

        String fieldName = columns.get(0).getName();
        Object val = Reflection.getValue(o, fieldName);

        String bufferString = SQLHelper.toSqlValue(val);

        for(int i = 1; i < columns.size(); i++) {
            stringBuilder.append(bufferString).append(" , ");

            fieldName = columns.get(i).getName();
            val = Reflection.getValue(o, fieldName);
            bufferString = SQLHelper.toSqlValue(val);
        }
        stringBuilder.append(bufferString).append(" );");

        return stringBuilder.toString();
    }





    public static String delete(String tableName, long id){
        return "DELETE FROM %s WHERE id = %d;".formatted(tableName, id);
    }
    public static String delete(Class tableName, long id){
        return delete(tableName.getSimpleName(), id);
    }



    public static String update(String tableName, int id, Object o) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("UPDATE %s SET ".formatted(tableName));

        Map<String, Object> values = SQLHelper.getFilledValues(o);

        List<String> columns = new ArrayList<>(values.keySet());

        String col = columns.get(0);
        Object val = values.get(col);

        String bufferString = " %s = %s ".formatted(col, SQLHelper.toSqlValue(val));
        for (int i = 1; i < columns.size(); i++) {

            stringBuilder.append(bufferString).append(" , ");
            col = columns.get(i);
            val = values.get(col);

            bufferString = " %s = %s ".formatted(col, SQLHelper.toSqlValue(val));
        }
        stringBuilder.append(bufferString).append(" WHERE id = %d;".formatted(id));
        return stringBuilder.toString();
    }
    public static String update(Class tableName, int id, Object o) throws Exception {
        return update(tableName.getSimpleName(), id, o);
    }


    public static String find(String tableName, int id){
        return "SELECT * FROM %s WHERE id = %d;".formatted(tableName, id);
    }
    public static String find(Class tableName, int id){
        return find(tableName.getSimpleName(), id);
    }


    public static String find(String tableName){
        return "SELECT * FROM %s;".formatted(tableName);
    }

    public static String find(Class tableName){
        return find(tableName.getSimpleName());
    }























}
