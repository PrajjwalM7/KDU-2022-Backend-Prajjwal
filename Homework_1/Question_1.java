import java.io.*;

public class Question_1 {
    public static void main(String[] args) throws IOException {
        // N - A number >= the last number in the series to be printed
        int N;

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);

        System.out.println("Enter the value of N : ");
        N = Integer.parseInt(buf.readLine());

        // Series 1 : 1, 4, 7, 12, 23, 42, 77, ... N
        System.out.print("Pattern 1 : ");
        int a = 1, b = 4, c = 7, d = 12; // First 4 terms of the series

        if( a <= N ) {
            System.out.print(a + " ");
        }
        if( b <= N ) {
            System.out.print(b + " ");
        }
        if( c <= N ) {
            System.out.print(c + " ");
        }
        if( d <= N ) {
            System.out.print(d + " ");
        }

        // 3 Latest term differences
        int d1 = b - a;
        int d2 = c - b;
        int d3 = d - c;

        int n = d;
        while( d <= N ) {
            n += d1 + d2 + d3;
            d1 = d2;
            d2 = d3;
            d3 = n - d;
            d = n;
            if( n <= N )
                System.out.print(d + " ");
        }

        // Series 2 : 1, 4, 9, 25, 36, 49, 81, 100, ... N
        System.out.print("\nPattern 2 : ");

        int i = 1;

        while(i*i <= N) {
            System.out.print(i*i + " ");
            i++;
        }

        // Series 2 : 1, 5, 13, 29, 49, 77, ... N
        System.out.print("\nPattern 3 : ");

        int start = 1;

        if( N >= start) {
            System.out.print(start + " ");
        }

        for(int j = 1; start + (4 * j) <= N; j++) {
            if( j % 3 != 0) {
                System.out.print(start + (4 * j) + " ");
                start += 4 * j;
            }
        }
    }
}
