package ua.training.utils.management.localization;

public class NonexistentPropertiesException extends RuntimeException {
    NonexistentPropertiesException() {
        super();
    }

    NonexistentPropertiesException(String message) {
        super(message);
    }

    NonexistentPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
