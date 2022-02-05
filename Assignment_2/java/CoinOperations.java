import CustomExceptions.CoinNotFound;
import CustomExceptions.InvalidInput;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoinOperations {
    public static void fetchCoinDetails(String query) throws CoinNotFound, InvalidInput {
        if(query.length() == 0 || query.trim().length() == 0) {
            throw new InvalidInput("Invalid Input");
        } else {
            Coin newCoin;
            query = query.toUpperCase();
            if((newCoin = CoinBuilder.getCoin(query)) != null) {
                System.out.println(newCoin);
            } else if((newCoin = CoinBuilder.getCoinByName(query)) != null) {
                System.out.println(newCoin);
            } else {
                throw new CoinNotFound("No such coin exists");
            }
        }
    }

    public static void fetchTopKCoins() {
        int NUMBER_OF_COINS = 50;
        List<Coin> listOfCoins = CoinBuilder.getCoinList();
        sortCoinsByPrice(listOfCoins);
        for(int i = 0; i < NUMBER_OF_COINS; i++) {
            System.out.println(listOfCoins.get(i).getSymbol() + " ---> " + listOfCoins.get(i).getPrice());
        }
    }

    private static void sortCoinsByPrice(List<Coin> listOfCoins) {
        Collections.sort(listOfCoins, new Comparator<Coin>() {
            @Override
            public int compare(Coin c1, Coin c2) {
                return (c1.getPrice() - c2.getPrice() >= 0) ? -1 : 1;
            }
        });
    }
}
