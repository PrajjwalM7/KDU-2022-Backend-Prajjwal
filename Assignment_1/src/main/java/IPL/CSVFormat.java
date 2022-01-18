package IPL;

import java.lang.annotation.*;

// An Annotator that will help convert an object to CSV Format

// Objects whose classes are marked with CSVFormat will only be formatted
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CSVFormat {}
