import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// To demonstrate Type Annotators
@Target(ElementType.TYPE_USE)
@interface Type_Annotator{}


class Vehicle {
    public void repair() {
        System.out.println("Vehicle Repair");
    }
}

class Car extends Vehicle {
    // An example of marker annotation
    @Override
    public void repair() {
        System.out.println("Car Repaired !");
    }

    public Car() {}

//     Single Value Annotations
    @SuppressWarnings("unused")
    public @Type_Annotator double speed() {
        // Type Annotator for return type of the fuction
        double speed = 50.3;
        double changeInSpeedPerSecond = 2.2;
        System.out.println(speed);
        return speed;
    }

    @Deprecated
    public void discBreak() {
        System.out.println("Applying Disc Breaks");
    }
}

public class HW_5_Q_1 {
    public static void main(String[] args) {
        Car alto = new Car();
        alto.repair();
        alto.speed();
        // Striked off as it is marked Deprecated
        alto.discBreak();
    }
}
