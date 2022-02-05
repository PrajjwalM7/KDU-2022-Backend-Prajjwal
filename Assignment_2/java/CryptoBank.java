import CustomExceptions.CoinNotFound;
import CustomExceptions.InvalidInput;
import CustomExceptions.TraderNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptoBank {

    static Crypto_Statistics []numberToEnum = {
            Crypto_Statistics.SHOW_MENU, Crypto_Statistics.COIN_DETAILS,
            Crypto_Statistics.CRYPTY_FIFTY, Crypto_Statistics.TRADER_PORTFOLIO,
            Crypto_Statistics.TRADER_SUMMARY, Crypto_Statistics.WORLD_TRADER_RANK
    };

    public static void showMenu() {
        System.out.println(" 0 - Show Menu ");
        System.out.println(" 1 - Get the details of a Coin");
        System.out.println(" 2 - Top 50 Crypto coins in the Market");
        System.out.println(" 3 - Trader Portfolio");
        System.out.println(" 4 - Trader Summary (Total Prolit / Loss)");
        System.out.println(" 5 - Best and Worst performers in the market");
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the world of Crypto!");
        TransactionBuilderThread builder = new TransactionBuilderThread();
        builder.start();
        CoinBuilder.buildCoins();
        TraderBuilder.buildTraders();

        System.out.println("------------------------------------------------------------------------------------------");
        showMenu();
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("Choose any (0 - 5) to continue and any other number to exit - ");
        int choice = Integer.parseInt(buf.readLine());
        System.out.println("------------------------------------------------------------------------------------------");

        while(choice >= 0 && choice <= 5) {
            Crypto_Statistics stat = numberToEnum[choice];
            switch (stat) {
                case SHOW_MENU:
                    showMenu();
                    break;
                case COIN_DETAILS:
                    String query = buf.readLine();
                    try {
                        CoinOperations.fetchCoinDetails(query);
                    } catch(CoinNotFound c) {
                        System.out.println("Error : " + c.getMessage());
                    } catch(InvalidInput i) {
                        System.out.println("Error : " + i.getMessage());
                    }
                    break;
                case CRYPTY_FIFTY:
                    CoinOperations.fetchTopKCoins();
                    break;
                case TRADER_PORTFOLIO:
                    try {
                        String trader = buf.readLine();
                        TraderOperations.traderPortFolio(trader);
                    } catch (TraderNotFound t) {
                        System.out.println("Error : " + t.getMessage());
                    } catch (InvalidInput i) {
                        System.out.println("Error : " + i.getMessage());
                    }
                    break;
                case TRADER_SUMMARY:
                    try {
                        String traderQuery = buf.readLine();
                        TraderOperations.traderSummary(traderQuery);
                    } catch(TraderNotFound t) {
                        System.out.println("Error : " + t.getMessage());
                    } catch(InvalidInput i) {
                        System.out.println("Error : " + i.getMessage());
                    }
                    break;
                case WORLD_TRADER_RANK:
                    TraderOperations.worldRankingK();
                    break;
                default:
                    System.out.println("Did not match the menu. Exiting...");
            }
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Choose any (0 - 5) to continue and any other number to exit - ");
            choice = Integer.parseInt(buf.readLine());
            System.out.println("------------------------------------------------------------------------------------------");
        }

    }
}
