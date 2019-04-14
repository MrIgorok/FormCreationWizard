package ua.training.wizards.form.controller;

import ua.training.wizards.form.model.Address;
import ua.training.wizards.form.model.SubscriberEntry;
import ua.training.wizards.form.model.WizardModel;
import ua.training.wizards.form.view.WizardConsoleView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
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
        printWelcomeMessage();
        languageChose();
        printWelcomeMessage();

        return readSubscriberEntry();
    }

    private void printWelcomeMessage() {
        printMessage(WELCOME_MESSAGE);
    }

    private void languageChose() {
        String supportedLanguages = getSupportedLanguageMessages();
        printMessage(SUPPORTED_LANGUAGES, supportedLanguages);
        printMessage(LANGUAGE_CHOSE_SUGGESTION);
        String localeName = view.readString();
        Locale locale = new Locale(localeName);

        while (!model.supportLanguage(locale)) {
            printMessage(LANGUAGE_NOT_SUPPORTED, localeName);
            printMessage(SUPPORTED_LANGUAGES, supportedLanguages);
            printMessage(LANGUAGE_CHOSE_SUGGESTION);
            locale = new Locale(view.readString());
        }

        view.setResourceLocale(locale);
        model.setWizardLocale(locale);
    }

    private SubscriberEntry readSubscriberEntry() {
        SubscriberEntry subscriberEntry = new SubscriberEntry();
        Class entryClass = subscriberEntry.getClass();
        Field[] fields = entryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType() == String.class) {
                String res;

                printMessage(INPUT_SUGGESTION, field.getName());
                res = view.readString().trim();

                while (!model.validate(field.getName(), res)) {
                    printMessage(WRONG_INPUT);
                    printMessage(INPUT_SUGGESTION, field.getName());
                    res = view.readString();
                }

                char [] nameCharacters = field.getName().toCharArray();
                nameCharacters[0] = Character.toUpperCase(nameCharacters[0]);
                String methodName = "set" + new String(nameCharacters);
                Method method;
                try {
                    method = entryClass.getMethod(methodName, String.class);
                    method.invoke(subscriberEntry, res);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    System.err.println(e.getMessage());
                }

            } else if (field.getType() == Address.class) {

            } else if (field.getType() == Date.class) {

            }
        }

        return subscriberEntry;
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

    public void outputSubscriberEntry(SubscriberEntry subscriberEntry) {
        Class entryClass = subscriberEntry.getClass();
        Field[] fields = entryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType() == String.class) {
                try {
                    char [] nameCharacters = field.getName().toCharArray();
                    nameCharacters[0] = Character.toUpperCase(nameCharacters[0]);
                    String methodName = "get" + new String(nameCharacters);
                    Method method = entryClass.getMethod(methodName);
                    view.printMessage(field.getName() + ": " + method.invoke(subscriberEntry));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    System.err.println(e.getMessage());
                }

            } else if (field.getType() == Address.class) {

            } else if (field.getType() == Date.class) {

            }
        }
    }

    public void reInputLogin(SubscriberEntry subscriberEntry) {
        printMessage(LOGIN_ALREADY_EXIST, subscriberEntry.getNickname());
        printMessage(INPUT_SUGGESTION, "nickname");
        String res = view.readString().trim();

        while (!model.validate("nickname", res)) {
            printMessage(WRONG_INPUT);
            printMessage(INPUT_SUGGESTION, "nickname");
            res = view.readString();
        }

        subscriberEntry.setNickname(res);
    }

    private void printMessage(WizardConsoleView.DialogValue dialogValue, String ... args) {
        view.printMessage(view.getDialogValueAndSetFormatValue(dialogValue, args));
    }
}
