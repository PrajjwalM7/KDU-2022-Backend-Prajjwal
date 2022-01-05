import java.io.*;

public class Question_3 {
    public static void main(String[] args) throws IOException {
        String str;

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);

        System.out.println("Enter the string : ");
        str = buf.readLine();
        int c = 0;
        for( int i = 0, j = str.length() - 1; i <= j; i++, j-- ) {
            if(str.charAt(i) != str.charAt(j)) {
                c = 1;
                break;
            }
        }
        if( c == 1) {
            System.out.println(str + " is not a palindrome.");
        } else {
            System.out.println(str + " is a palindrome.");
        }
    }
}
