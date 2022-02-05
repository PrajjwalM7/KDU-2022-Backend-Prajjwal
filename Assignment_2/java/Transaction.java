public class Transaction extends Thread {
    protected String coin;

    Transaction(String coin) {
        this.coin = coin;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public void run() {}
}
