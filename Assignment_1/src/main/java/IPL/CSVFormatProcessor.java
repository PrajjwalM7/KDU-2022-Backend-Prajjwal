package IPL;

import java.lang.reflect.Field;
import java.util.Objects;

public class CSVFormatProcessor {

    public String format(Object object) {
        String result = "";
        try {
            checkFormattingCriteria(object);
            result = formatObject(object);
        } catch (Exception e) {
            System.out.println("Could Not Format Object : " + e.getMessage());
        }
        return result;
    }

    private void checkFormattingCriteria(Object object) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception("Null Object has nothing to be formatted!");
        }
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(CSVFormat.class)) {
            throw new Exception("The class " + clazz.getSimpleName() + " is not annotated with CSVFormat and hence can't be formatted.");
        }
    }

    private String formatObject(Object object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        String result = "";
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(formatValue.class)) {
                result += returnFieldValue(field, object);
            }
        }
        // An extra comma is added which is removed in the substring
        return result.substring(0, result.length() - 1);
    }

    private String returnFieldValue(Field field, Object object) throws IllegalAccessException {
        if(field.getType() == Team.class) {
            return ((Team) field.get(object)).getName() + ",";
        } else {
            return field.get(object) + ",";
        }
    }

}
