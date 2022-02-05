public class Sell extends Transaction {
    private String wallet;
    private long quantity;

    Sell(String coin, long quantity, String wallet) {
        super(coin);
        this.quantity = quantity;
        this.wallet = wallet;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public void run() {
        Coin sellCoin = CoinBuilder.getCoin(super.coin);
        Trader trader = TraderBuilder.getTrader(this.wallet);
        if(sellCoin != null) {
            if (trader.getPortfolio().getCoinBalance(coin) > this.quantity) {
                String hash = HashCode.getBlockHash();
                double priceSoldAt = sellCoin.completeSell(this.quantity);
                trader.getPortfolio().addTransaction(sellCoin.getSymbol(), -1 * this.quantity, priceSoldAt);
            } else {
//            throw new InsufficientVolumeToSell("The trader does not have sufficient volume to sell");
            }
        }
    }
}
