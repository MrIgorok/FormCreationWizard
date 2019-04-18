package ua.training.wizards.form.controller;

import ua.training.wizards.form.model.SubscriberEntry;
import ua.training.wizards.form.model.WizardModel;
import ua.training.wizards.form.view.WizardConsoleView;

import java.util.Locale;

import static ua.training.wizards.form.view.WizardConsoleView.DialogValue.*;

/**
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class WizardController {
    private WizardModel model;
    private WizardConsoleView view;

    public WizardController(WizardModel model, WizardConsoleView view) {
        this.model = model;
        this.view = view;

        this.model.setController(this);
    }

    public SubscriberEntry performSubscriberEntryWizard() {
        InputOutputSubscriberEntryController ioSubscriberEntry = new InputOutputSubscriberEntryController(model, view);
        printWelcomeMessage();
        choseApplicationLanguage();
        printWelcomeMessage();

        return ioSubscriberEntry.readSubscriberEntry();
    }

    private void printWelcomeMessage() {
        printMessage(WELCOME_MESSAGE);
    }

    private void choseApplicationLanguage() {
        Locale locale;
        showLanguageChoseSuggestion();
        locale = inputLanguage();

        while (!model.supportLanguage(locale)) {
            showLanguageNotSupported(locale);
            showLanguageChoseSuggestion();
            locale = inputLanguage();
        }

        setApplicationLocale(locale);
    }

    private void showLanguageChoseSuggestion() {
        String supportedLanguages = getSupportedLanguageMessages();
        printMessage(SUPPORTED_LANGUAGES, supportedLanguages);
        printMessage(LANGUAGE_CHOSE_SUGGESTION);
    }

    private Locale inputLanguage() {
        String localeName = view.readString();
        return new Locale(localeName);
    }

    private void showLanguageNotSupported(Locale locale) {
        printMessage(LANGUAGE_NOT_SUPPORTED, locale.getLanguage());
    }

    private void setApplicationLocale(Locale locale) {
        view.setResourceLocale(locale);
        model.setWizardLocale(locale);
    }

    private String getSupportedLanguageMessages() {
        StringBuilder buffer = new StringBuilder();
        Locale [] locales = WizardModel.getSupportedLanguages();

        for (Locale locale : locales) {
            buffer.append(locale.getLanguage());
            buffer.append(' ');
        }

        return buffer.toString();
    }

    private void printMessage(WizardConsoleView.DialogValue dialogValue, String ... args) {
        view.printMessage(view.getDialogValueAndSetFormatValue(dialogValue, args));
    }

    public void outputSubscriberEntry(SubscriberEntry subscriberEntry) {
        InputOutputSubscriberEntryController ioSubscriberEntry = new InputOutputSubscriberEntryController(model, view);
        ioSubscriberEntry.outputSubscriberEntry(subscriberEntry);
    }

    public void reInputLogin(SubscriberEntry subscriberEntry) {
        InputOutputSubscriberEntryController ioSubscriberEntry = new InputOutputSubscriberEntryController(model, view);
        ioSubscriberEntry.reInputLogin(subscriberEntry);
    }
}
