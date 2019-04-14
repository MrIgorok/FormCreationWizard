package ua.training.wizards.form.model;

import java.util.ArrayList;

public class SubscriberEntryDAO {
    private static ArrayList<String> logins = new ArrayList<>();

    static {
        logins.add("mrigorok");
        logins.add("namename");
        logins.add("billbill");
    }

    public void create(SubscriberEntry entry) throws LoginAlreadyExistsException {
        if (logins.contains(entry.getNickname())) {
            throw new LoginAlreadyExistsException("Login: " + entry.getNickname()  + " already exists", entry);
        }

        logins.add(entry.getNickname());
    }
}
