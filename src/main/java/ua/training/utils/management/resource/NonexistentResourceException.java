package ua.training.utils.management.resource;

public class NonexistentResourceException extends RuntimeException {
    public NonexistentResourceException() {
        super();
    }

    public NonexistentResourceException(String massage) {
        super(massage);
    }

    public NonexistentResourceException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
