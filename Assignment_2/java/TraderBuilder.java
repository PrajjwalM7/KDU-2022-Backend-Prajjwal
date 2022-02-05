import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TraderBuilder {

    private static String traderDetailsFile = "src/main/resources/traders.csv";
    private static Map<String, Trader> traders = new HashMap<String, Trader>();
    private static Map<String, String> nameToWallet = new HashMap<String, String>();

    public static void buildTraders() {
        BufferedReader buf;
        String line;

        try {
            buf = new BufferedReader(new FileReader(new File(traderDetailsFile)));

            // To ignore the headers in the csv file
            String header = buf.readLine();

            while((line = buf.readLine()) != null) {
                List<String> tokens = List.of(line.split(",", 7));
                createTrader(tokens);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found.");
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private static void createTrader(List<String> traderDetails) {
        Trader newTrader = new Trader(
                traderDetails.get(1), traderDetails.get(2),
                traderDetails.get(3), traderDetails.get(4));
        traders.put(traderDetails.get(4), newTrader);
        nameToWallet.put(traderDetails.get(1) + traderDetails.get(2), traderDetails.get(4));
    }

    public static Trader getTrader(String wallet) {
        return traders.get(wallet);
    }

    public static Trader getTraderByName(String name) {
        for(Map.Entry<String, String> mp : nameToWallet.entrySet()) {
            if(mp.getKey().toLowerCase().contains(name.toLowerCase())) {
                return traders.get(mp.getValue());
            }
        }
        return null;
    }

    public static Map<String, Trader> getTradersList() {
        return traders;
    }
}
