import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HW_4_Q_2 {
    public static void forLoopSum(List<Integer> numbers) {
        long forStart = System.nanoTime();
        long forSum = 0;
        for(int i = 0; i < numbers.size(); i++) {
            forSum += numbers.get(i);
        }
        long forEnd = System.nanoTime();
        System.out.println("Calculated sum using For = " + forSum + " in " + (forEnd - forStart) + " ns");
    }

    public static void forEachLoopSum(List<Integer> numbers) {
        long forEachStart = System.nanoTime();
        long forEachSum = 0;
        for (Integer num : numbers) {
            forEachSum += num;
        }
        long forEachEnd = System.nanoTime();
        System.out.println("Calculated sum using ForEach = " + forEachSum + " in " + (forEachEnd - forEachStart) + " ns");
    }

    public static void streamSum(List<Integer> numbers) {
        long streamStart = System.nanoTime();
        long streamSum = 0;
        streamSum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        long streamEnd = System.nanoTime();
        System.out.println("Calculated sum using stream = " + streamSum + " in " + (streamEnd - streamStart) + " ns");
    }

    public static void streamParallelSum(List<Integer> numbers) {
        long streamParallelStart = System.nanoTime();
        long streamParallelSum = 0;
        streamParallelSum = numbers.parallelStream().collect(Collectors.summingInt(Integer::intValue));
        long streamParallelEnd = System.nanoTime();
        System.out.println("Calculated sum using parallel stream = " + streamParallelSum + " in " + (streamParallelEnd - streamParallelStart) + " ns");
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        // for loop
        forLoopSum(numbers);

        // forEach loop
        forEachLoopSum(numbers);

        // stream
        streamSum(numbers);

        // parallel stream
        streamParallelSum(numbers);
    }
}
