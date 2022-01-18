package IPL;

import java.lang.annotation.*;

// Fields marked with formatValue will only be included in the formatted string
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface formatValue {
    String key() default "";
}