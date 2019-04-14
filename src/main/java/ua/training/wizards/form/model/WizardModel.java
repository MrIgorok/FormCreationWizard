package ua.training.wizards.form.model;

import ua.training.wizards.form.controller.WizardController;

import java.util.Locale;

public class WizardModel {
    private static Locale[] supportedLanguages;
    private static final String regexPropertiesResourceName = "regexes.regex";

    private WizardController wizardController;
    private Validator validator = new Validator(regexPropertiesResourceName);
    private SubscriberEntryDAO subscriberEntryDAO = new SubscriberEntryDAO();

    static {
        supportedLanguages = new Locale[] { new Locale("uk"),
                new Locale("en"), new Locale("ge")};
    }

    public WizardModel() {

    }

    public void createNewSubscriberEntry() {
        SubscriberEntry subscriberEntry = wizardController.performSubscriberEntryWizard();
        wizardController.outputSubscriberEntry(subscriberEntry);

        createDBSubscriberEntry(subscriberEntry);

        wizardController.outputSubscriberEntry(subscriberEntry);
    }

    private void createDBSubscriberEntry(SubscriberEntry subscriberEntry) {
        try {
            subscriberEntryDAO.create(subscriberEntry);
        } catch (LoginAlreadyExistsException e) {
            reInputLoginAndCreateSubscriberEntry(e);
        }
    }

    private void reInputLoginAndCreateSubscriberEntry(LoginAlreadyExistsException e) {
        try {
            wizardController.outputSubscriberEntry(e.getEntry());
            wizardController.reInputLogin(e.getEntry());
            subscriberEntryDAO.create(e.getEntry());
        } catch (LoginAlreadyExistsException exception) {
            reInputLoginAndCreateSubscriberEntry(exception);
        }
    }

    public boolean validate(String fieldName, String value) {
        return validator.validate(fieldName, value);
    }

    public static Locale[] getSupportedLanguages() {
        return supportedLanguages;
    }

    public boolean supportLanguage(Locale locale) {
        for (Locale elm : supportedLanguages) {
            if (elm.equals(locale)) {
                return true;
            }
        }

        return false;
    }

    public void setController(WizardController controller) {
        wizardController = controller;
    }

    public void setWizardLocale(Locale locale) {
        validator.setValidationLocale(locale);
    }

}
