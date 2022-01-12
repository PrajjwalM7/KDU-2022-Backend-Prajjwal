import java.util.Arrays;
import java.util.Objects;

class Employee implements Comparable<Employee> {
    String name;
    int salary;
    double equity;
    Employee(String name, int salary, double equity) {
        this.name = name;
        this.salary = salary;
        this.equity = equity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    @Override
    public int compareTo(Employee o) {
        return (this.salary >= o.salary) ? 1 : -1;
    }
}
public class HW_3_Q_1 {
    public static void main(String[] args) {
        Employee[] emp = {
                new Employee("Prajjwal", 10000, 10.5),
                new Employee("Smita", 2000, 8.5),
                new Employee("Aastha", 70000, 15),
                new Employee("Aditya", 1000, 3.0),
                new Employee("Prashant", 15000, 1.5)
        };
        Arrays.sort(emp);
        for(int i = 0; i < 5; i++) {
            System.out.println(emp[i].name + " -> " + emp[i].salary);
        }
    }
}
