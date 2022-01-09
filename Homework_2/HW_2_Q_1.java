class Credentials {
    private String str = "JAVA";
    private int n = 7;
    private Credentials() {

    }

    public String getStr() {
        return str;
    }

    public static Credentials createObj() {
        return new Credentials();
    }
    public int getInt() {
        return n;
    }
}

public class HW_2_Q_1 {
    public static void main(String[] args) {
        Credentials cred = Credentials.createObj();
        System.out.println("Integer is : " + cred.getInt());
        System.out.println("String is : " + cred.getStr());
    }
}
