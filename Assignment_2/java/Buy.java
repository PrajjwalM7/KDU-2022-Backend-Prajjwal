public class Buy extends Transaction {
    private long quantity;
    private String wallet;

    Buy(String coin, long quantity, String wallet) {
        super(coin);
        this.quantity = quantity;
        this.wallet = wallet;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public void run() {
        Coin buyCoin = CoinBuilder.getCoin(super.coin);
        Trader trader = TraderBuilder.getTrader(this.wallet);
        String hash = HashCode.getBlockHash();
        if(buyCoin != null) {
            double priceBoughtAt = buyCoin.completeBuy(quantity);
            trader.getPortfolio().addTransaction(buyCoin.getSymbol(), this.quantity, priceBoughtAt);
        }
    }
}
