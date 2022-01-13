import java.lang.reflect.Field;
import java.util.Objects;
import java.lang.annotation.*;

// Creating an Annotator that will help print only the selected values of an object

// Variables marked PrintValue will only be printed
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface PrintValue {
    String key() default "";
}

// Objects whose classes are marked with PrintObject will only be printed
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface PrintObject {}



class PrintObjectProcessor {

    public void print(Object object) throws Exception {
        checkPrintingCriteria(object);
        printObject(object);
    }

    private void checkPrintingCriteria(Object object) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception("Null Object has nothing to be printed!");
        }

        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(PrintObject.class)) {
            throw new Exception("The class " + clazz.getSimpleName() + " is not annotated with PrintObject and hence can't be printed");
        }
    }

    private void printObject(Object object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(PrintValue.class)) {
                System.out.println(getKey(field) + " -> " + field.getType().cast(field.get(object)));
            }
        }
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(PrintValue.class)
                .key();
        return value.isEmpty() ? field.getName() : value;
    }
}

@PrintObject
class Cars {
    @PrintValue String name;
    @PrintValue Long price;
    Integer modelNo;
    Cars(String name, long price, Integer modelNo) {
        this.name = name;
        this.price = price;
        this.modelNo = modelNo;
    }
}

public class HW_5_Q_2 {
    public static void main(String[] args) throws Exception {
        Cars bmw = new Cars("BMW", 100000, 302);
        PrintObjectProcessor p = new PrintObjectProcessor();
        // As the modelNo of Cars is not marked PrintValue, it will not be printed
        p.print(bmw);
    }
}
