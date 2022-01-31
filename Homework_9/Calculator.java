import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }
    public double minus(double a, double b) {
        return a - b;
    }
    public double product(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        return a / b;
    }
    public double print(double a) {
        System.out.println(a);
        return a;
    }

}
