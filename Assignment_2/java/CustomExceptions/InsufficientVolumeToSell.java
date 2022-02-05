package CustomExceptions;

public class InsufficientVolumeToSell extends Exception {
    public InsufficientVolumeToSell(String errorMessage) {
        super(errorMessage);
    }
}
