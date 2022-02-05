import java.util.*;

public class Portfolio {

    /*
        The Map below stores list of transactions for each coin. The first List within the list
        stores the total quantity present with the user and the following lists within the main
        list contain the transactions in the format [Quantity, Price]. Sell transactions have a
        negative quantity and Buy transactions have a positive quantity.
        The history is used to calculate the profits and losses of the trader.
     */
    public Map<String, List<List<Double>>> portfolio;
    private double profit;

    Portfolio() {
        portfolio = new HashMap<String, List<List<Double>>>();
    }

    public double getProfit() {
        return this.profit;
    }

    public void addTransaction(String coin, Long quantity, Double price) {
        if(portfolio.containsKey(coin)) {
            synchronized (portfolio.get(coin)) {
                List<List<Double>> transactionStats = portfolio.get(coin);
                transactionStats.add(new ArrayList<Double>(Arrays.asList(quantity.doubleValue(), price)));

                // Updating the total quantity with the trader
                transactionStats.get(0).set(0, transactionStats.get(0).get(0) + quantity.doubleValue());
            }
        } else {
            List<List<Double>> transactionStats = new ArrayList<List<Double>>();

            // The first entry for each coin maintains the total quantity of that coin with the user
            transactionStats.add(new ArrayList<Double>(Arrays.asList(quantity.doubleValue())));
            transactionStats.add(new ArrayList<Double>(Arrays.asList(quantity.doubleValue(), price)));
            synchronized (portfolio) {
                portfolio.put(coin, transactionStats);
            }
        }
    }

    public Long getCoinBalance(String coin) {
        if(portfolio.containsKey(coin)) {
            synchronized (portfolio.get(coin)) {
                List<List<Double>> transactionStats = portfolio.get(coin);
                return transactionStats.get(0).get(0).longValue();
            }
        } else {
            return new Long(0);
        }
    }

    public void showPortfolio() {
        for(Map.Entry<String, List<List<Double>>> mp : portfolio.entrySet()) {
            System.out.println(mp.getKey() + " --- " + mp.getValue().get(0).get(0));
        }
    }

    public void showSummary() {
        for(Map.Entry<String, List<List<Double>>> mp : portfolio.entrySet()) {
            String coin = mp.getKey();
            double currentPrice = CoinBuilder.getCoin(coin).getPrice();
            double holdingProfitValue = 0;
            double soldWorth = 0;
            double assetWorth = 0;
            List<List<Double>> transacts = mp.getValue();
            for(int i = 1; i < mp.getValue().size(); i++) {
                if (transacts.get(i).get(0) < 0) {
                    soldWorth += (((-1) * transacts.get(i).get(0)) * transacts.get(i).get(1));
                } else {
                    holdingProfitValue += (transacts.get(i).get(0) * (currentPrice - transacts.get(i).get(1)));
                    assetWorth += (transacts.get(i).get(0) * transacts.get(i).get(1));
                }
            }
            if(holdingProfitValue > 0)
                System.out.println(coin + " ::::: Profit : " + holdingProfitValue +
                        " ::::: Earned by selling : " + soldWorth + " ::::: Holding Assets Worth : " + assetWorth);
            else
                System.out.println(coin + " ::::: Loss : " + (-1) * holdingProfitValue +
                        " ::::: Earned by selling : " + soldWorth + " ::::: Holding Assets Worth : " + assetWorth);
        }
    }

    public void calculateTotalPL() {
        double totalPL = 0;
        for(Map.Entry<String, List<List<Double>>> mp : portfolio.entrySet()) {
            String coin = mp.getKey();
            double currentPrice = CoinBuilder.getCoin(coin).getPrice();
            double holdingProfitValue = 0;
            List<List<Double>> transacts = mp.getValue();
            for(int i = 1; i < mp.getValue().size(); i++) {
                if (transacts.get(i).get(0) > 0) {
                    holdingProfitValue += (transacts.get(i).get(0) * (currentPrice - transacts.get(i).get(1)));
                }
            }
            totalPL += holdingProfitValue;
        }
        profit = totalPL;
    }
}
