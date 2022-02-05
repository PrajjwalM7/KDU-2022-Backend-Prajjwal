public class Coin {
    private String name;
    private String symbol;
    private Double price;
    private Long supply;

    public Coin(String name, String symbol, double price, long supply) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        synchronized(this.price) {
            this.price = price;
        }
    }

    public long getSupply() {
        return supply;
    }

    public void setSupply(long supply) {
        synchronized((Long) this.supply) {
            this.supply = supply;
        }
    }

    @Override
    public String toString() {
        return  "Name = " + name + " ---- Symbol = " + symbol + " ---- Price = " + price + " ---- Supply = " + supply;
    }

    public double completeBuy(double quantity) {

        synchronized (this) {
            while (this.supply < quantity) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println("Error : " + e);
                }
            }
            double p = this.getPrice();
            this.setSupply((Long) (this.getSupply() - (long) quantity));
            return p;
        }
    }

    public double completeSell(long quantity) {

        synchronized (this) {
            double p = this.getPrice();
            this.setSupply(this.supply + quantity);
            this.notifyAll();
            return p;
        }

    }

    public void completeVolume(long volume) {

        synchronized (this) {
            this.setSupply(this.supply + volume);
            this.notifyAll();
        }

    }

    public void completePriceUpdate(double price) {

        synchronized (this) {
            this.setPrice(price);
        }

    }


}
