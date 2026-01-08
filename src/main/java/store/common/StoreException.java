package store.common;

public class StoreException extends IllegalArgumentException {
    public StoreException(String message) {
        super("[ERROR] " + message);
    }
}