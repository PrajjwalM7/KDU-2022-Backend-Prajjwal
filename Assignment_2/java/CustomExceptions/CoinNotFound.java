package CustomExceptions;

public class CoinNotFound extends Exception {
    public CoinNotFound(String errorMessage) {
        super(errorMessage);
    }
}
