import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Calculator calc = context.getBean(Calculator.class);
        System.out.println("Add - " + calc.add(10, 12));
        System.out.println("Minus - " + calc.minus(10, 12));
        System.out.println("Multiply - " + calc.product(10, 12));
        System.out.println("Divide - " + calc.divide(10, 12));
        calc.print(10);
    }
}
