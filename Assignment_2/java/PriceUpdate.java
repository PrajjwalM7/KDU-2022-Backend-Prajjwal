public class PriceUpdate extends Transaction {
    private double price;

    PriceUpdate(String coin, double price) {
        super(coin);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void run() {
        Coin priceChangeCoin = CoinBuilder.getCoin(super.coin);
        if(priceChangeCoin != null)
            priceChangeCoin.completePriceUpdate(this.price);
    }
}
