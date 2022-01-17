public class HW_5_Q_3 {
    public static double findAverage(double numbers[]) {
        double sum = 0;
        for(double num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;
        return average;
    }

    public static void main(String[] args) {
        double numbers[] = {10.0, 20};
        double average = findAverage(numbers);
        System.out.println("Average : " + average);
    }
}
