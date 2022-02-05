import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadTransactions {

    static List<Buy> buyTransaction = new ArrayList<Buy>();
    static List<Sell> sellTransaction = new ArrayList<Sell>();
    static List<AddVolume> volumeTransaction = new ArrayList<AddVolume>();
    static List<PriceUpdate> priceTransaction = new ArrayList<PriceUpdate>();

    public static void serialize() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/main/resources/small_transaction.json");
        TransactionFactory[] transactions = objectMapper.readValue(file, TransactionFactory[].class);
        for (TransactionFactory eachTransaction : transactions) {
            switch (eachTransaction.getType()) {
                case "BUY":
                    Buy transactBuy = new Buy(
                            eachTransaction.getData().getCoin(),
                            eachTransaction.getData().getQuantity(),
                            eachTransaction.getData().getWallet_address());
                    buyTransaction.add(transactBuy);
                    transactBuy.start();
                    break;
                case "SELL":
                    Sell transactSell = new Sell(
                            eachTransaction.getData().getCoin(),
                            eachTransaction.getData().getQuantity(),
                            eachTransaction.getData().getWallet_address());
                    sellTransaction.add(transactSell);
                    transactSell.start();
                    break;
                case "UPDATE_PRICE":
                    PriceUpdate transactPrice = new PriceUpdate(
                            eachTransaction.getData().getCoin(),
                            eachTransaction.getData().getPrice());
                    priceTransaction.add(transactPrice);
                    transactPrice.start();
                    break;
                case "ADD_VOLUME":
                    AddVolume transactVolume = new AddVolume(
                            eachTransaction.getData().getCoin(),
                            eachTransaction.getData().getVolume());
                    volumeTransaction.add(transactVolume);
                    transactVolume.start();
                    break;
            }
        }
    }
}

