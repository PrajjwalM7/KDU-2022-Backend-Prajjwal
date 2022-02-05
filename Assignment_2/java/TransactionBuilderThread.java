import java.io.IOException;

public class TransactionBuilderThread extends Thread {
    public void run() {
        try {
            LoadTransactions.serialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
