import java.io.*;

public class HW_2_Q_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first string : ");
        String s1 = buf.readLine();
        System.out.println("Enter the second string : ");
        String s2 = buf.readLine();
        System.out.println("Enter the index : ");
        int ind = Integer.parseInt(buf.readLine());
        if(s1.contains(s2) == true) {
            for(int i = s1.length() - s2.length(); i >= 0; i--) {
                if(s1.substring(i).contains(s2) == true) {
                    System.out.println("Starting index of last occurrence of " + s2 + " in " + s1 + " : " + i);
                    break;
                }
            }
        } else {
            System.out.println(-1);
        }
        if(ind < 0 || ind > s1.length() - 1) {
            System.out.println("The index entered is not valid!");
        } else {
            String newS = s1.substring(0, ind + 1).concat(s2).concat(s1.substring(ind + 1));
            System.out.println(newS);
        }
    }
}
