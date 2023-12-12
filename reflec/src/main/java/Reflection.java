import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Reflection {
    public static void setValue(Object o, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = o.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(o, value);
    }
    public static Class<?> createClass(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("org.example.%s".formatted(className));
        return clazz;
    }
    public static Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = createClass(className);
        return clazz.newInstance();
    }


    public static List<Field> getFields(Class c, Predicate<Class> predicate){
        List<Field> fields = new ArrayList<>();
        Field[] fs = c.getDeclaredFields();
        for(int i = 0; i < fs.length; i++) {
            if(predicate.test(fs[i].getType()))
                fields.add(fs[i]);
        }
        return fields;
    }
    public static List<Field> getFields(Class c){
        return getFields(c, aClass -> Set.of(Integer.class, Long.class, int.class, long.class, String.class).contains(aClass));
    }

    public static Object getValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Method getter = clazz.getMethod("get" + toUpperFirstCymbol(fieldName));
        return getter.invoke(object);
    }

    private static String toUpperFirstCymbol(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
