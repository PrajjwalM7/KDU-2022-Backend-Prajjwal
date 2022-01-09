import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HW_2_Q_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string : ");
        String s1 = buf.readLine();
        String s = s1.toLowerCase();
        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            if(mp.containsKey(s.charAt(i))) {
                int val = mp.get(s.charAt(i));
                mp.put(s.charAt(i), val + 1);
            } else {
                mp.put(s.charAt(i), 1);
            }
        }
        System.out.print("New String : ");
        for(int i = 0; i < s.length(); i++) {
            if( mp.get(s.charAt(i)) >= 1) {
                System.out.print(s1.charAt(i));
                mp.put(s.charAt(i), -1);
            }
        }
    }
}
