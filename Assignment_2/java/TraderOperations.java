import CustomExceptions.InvalidInput;
import CustomExceptions.TraderNotFound;

import java.util.*;

public class TraderOperations {

    public static void traderPortFolio(String traderQuery) throws TraderNotFound, InvalidInput {
        traderQuery = traderQuery.trim();
        if(traderQuery.length() == 0) {
            throw new InvalidInput("Invalid Input");
        } else {
            Trader trader;
            if(traderQuery.charAt(0) == '0') {
                if((trader = TraderBuilder.getTrader(traderQuery)) != null) {
                    trader.getPortfolio().showPortfolio();
                }
            } else if((trader = TraderBuilder.getTraderByName(traderQuery)) != null) {
                trader.getPortfolio().showPortfolio();
            } else {
                throw new TraderNotFound("No such trader found");
            }
        }
    }

    public static void traderSummary(String traderQuery) throws TraderNotFound, InvalidInput {
        traderQuery = traderQuery.trim();
        if(traderQuery.length() == 0) {
            throw new InvalidInput("Invalid Input");
        } else {
            Trader trader;
            if(traderQuery.charAt(0) == '0') {
                if((trader = TraderBuilder.getTrader(traderQuery)) != null) {
                    trader.getPortfolio().showSummary();
                }
            } else if((trader = TraderBuilder.getTraderByName(traderQuery)) != null) {
                trader.getPortfolio().showSummary();
            } else {
                throw new TraderNotFound("Specified trader does not exist");
            }
        }
    }

    public static void worldRankingK() {
        int TOPK = 5;
        int BOTTOMK = 5;
        List<Trader> traders = new ArrayList<Trader>(TraderBuilder.getTradersList().values());
        for(Trader t : traders) {
            t.getPortfolio().calculateTotalPL();
        }
        sortTradersByProfit(traders);
        int len = traders.size();
        System.out.println("Worlds Top " + TOPK + " Traders : ");
        for(int i = 0; i < TOPK; i++) {
            System.out.println(traders.get(i).getFirstName() + " " +
                    traders.get(i).getLastName() + " ---> " + traders.get(i).getPortfolio().getProfit());
        }
        System.out.println("Worlds Bottom " + BOTTOMK + " Traders : ");
        for(int i = 0; i < BOTTOMK; i++) {
            System.out.println(traders.get(len - 1 - i).getFirstName() + " " +
                    traders.get(len - 1 - i).getLastName() + " ---> " + traders.get(len - 1 - i).getPortfolio().getProfit());
        }
    }

    private static void sortTradersByProfit(List<Trader> listOfTraders) {
        Collections.sort(listOfTraders, new Comparator<Trader>() {
            @Override
            public int compare(Trader t1, Trader c2) {
                return (t1.getPortfolio().getProfit() - c2.getPortfolio().getProfit() >= 0) ? -1 : 1;
            }
        });
    }
}
