package ua.training.wizards.form.model;

public class LoginAlreadyExistsException extends Exception {
    private SubscriberEntry entry;

    public LoginAlreadyExistsException() {
        super();
    }

    public LoginAlreadyExistsException(String message, SubscriberEntry entry) {
        super(message);
        this.entry = entry;
    }

    public LoginAlreadyExistsException(String message, Exception cause) {
        super(message, cause);
    }


    public SubscriberEntry getEntry() {
        return entry;
    }

    public void setEntry(SubscriberEntry entry) {
        this.entry = entry;
    }
}
