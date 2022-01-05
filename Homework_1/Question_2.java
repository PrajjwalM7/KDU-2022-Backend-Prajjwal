import java.io.*;

public class Question_2 {
    public static void printNumbersDivisibleByThree( int n ) {
        for( int i = 1; i <= n; i++ ) {
            int sum = 0;
            int d = i;
            while(d > 0) {
                int r = d % 10;
                sum += r;
                d = d / 10;
            }
            if( sum % 3 == 0) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int n;

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);

        System.out.println("Enter the value of n : ");
        n = Integer.parseInt(buf.readLine());

        if( n >= 1000 ) {
            System.out.println("Enter a number smaller than 1000.");
        } else {
            printNumbersDivisibleByThree(n);
        }
    }
}
