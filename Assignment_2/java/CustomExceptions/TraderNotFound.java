package CustomExceptions;

public class TraderNotFound extends Exception{
    public TraderNotFound(String errorMessage) {
        super(errorMessage);
    }
}
