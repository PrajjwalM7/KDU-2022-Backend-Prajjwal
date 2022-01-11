import java.io.*;

public class HW_2_Q_5 {
    public static void NumberFormatExceptionReplica() {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a number : ");
            int n = Integer.parseInt(buf.readLine());
        } catch(IOException e) {
            System.out.println("An IOException occured : " + e);
        } catch(NumberFormatException e) {
            System.out.println("Number Format Exception : " + e);
        }
    }
    public static void ArrayIndexException() {
        int[] a = {1, 2, 3};
        try {
            System.out.println(a[4]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("An ArrayIndexOutOfRange Exception occurred because you tried to access an index not present in the array : " + e);
        }
    }
    public static void ArithmeticExceptionReplicate() {
        try {
            int d = 5 / 0;
        } catch(ArithmeticException e) {
            System.out.println("Division by 0 causes an Arithmetic Exception : " + e);
        } finally {

        }
    }
    public static void IOExceptionReplica() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader(new File("Prajjwal.txt")));
        } catch(IOException e) {
            System.out.println("File not found : " + e);
        }
    }
    public static void tryCatchFinally() throws IOException{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n, d;
        try {
            System.out.println("Enter two numbers for division : ");
            n  = Integer.parseInt(buf.readLine());
            d = Integer.parseInt(buf.readLine());
            System.out.println("Answer : " + n / d);
        } catch(NumberFormatException e) {
            System.out.println("Please enter valid numbers!");
            try {
                n = Integer.parseInt(buf.readLine());
                d = Integer.parseInt(buf.readLine());
                int ans = n / d;
            } catch(NumberFormatException ex) {
                System.out.println("NumberFormatException found.");
            } catch(ArithmeticException a) {
                System.out.println("Division by zero is an Arithmetic Exception.");
            } finally {
                System.out.println("Inner finally block executed.");
            }
        } catch(ArithmeticException ar) {
            System.out.println("Division by zero is an Aeithmetic Exception.");
        } finally {
            System.out.println("Outer finally block executed.");
        }
    }
    public static void main(String[] args) throws IOException{
        IOExceptionReplica();
        NumberFormatExceptionReplica();
        ArrayIndexException();
        ArithmeticExceptionReplicate();
        tryCatchFinally();
    }
}
