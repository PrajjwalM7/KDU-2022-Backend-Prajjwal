import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinBuilder {

    private static String coinDetailsFile = "src/main/resources/coins.csv";
    private static Map<String, Coin> coins = new HashMap<String, Coin>();
    public static Map<String, String> nameToCode = new HashMap<String, String>();

    public static List<Coin> getCoinList() {
        return new ArrayList<Coin>(coins.values());
    }

    public static void buildCoins() {
        BufferedReader buf;
        String line;

        try {
            buf = new BufferedReader(new FileReader(new File(coinDetailsFile)));

            // To ignore the headers in the csv file
            String header = buf.readLine();

            while((line = buf.readLine()) != null) {
                List<String> tokens = List.of(line.split(",", 7));
                createCoin(tokens);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found.");
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void createCoin(List<String> coinDetails) {
        Coin newCoin = new Coin(
                coinDetails.get(2), coinDetails.get(3),
                Double.parseDouble(coinDetails.get(4)),
                Long.parseLong(coinDetails.get(5)));
        coins.put(coinDetails.get(3), newCoin);
        nameToCode.put(coinDetails.get(2), coinDetails.get(3));
    }

    public static Coin getCoin(String symbol) {
        return coins.get(symbol.toUpperCase());
    }

    public static Coin getCoinByName(String name) {
        for(Map.Entry<String, String> mp : nameToCode.entrySet()) {
            if(mp.getKey().toLowerCase().contains(name)) {
                return coins.get(mp.getValue());
            }
        }
        return null;
    }

}
