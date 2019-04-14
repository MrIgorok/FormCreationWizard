package ua.training.utils.management.localization;

class BadPropertiesFormatException extends RuntimeException {
    BadPropertiesFormatException() {
        super();
    }

    BadPropertiesFormatException(String message) {
        super(message);
    }

    BadPropertiesFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
