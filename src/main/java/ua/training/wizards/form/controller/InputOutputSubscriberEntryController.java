package ua.training.wizards.form.controller;

import ua.training.wizards.form.model.Address;
import ua.training.wizards.form.model.SubscriberEntry;
import ua.training.wizards.form.model.WizardModel;
import ua.training.wizards.form.view.WizardConsoleView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import static ua.training.wizards.form.view.WizardConsoleView.DialogValue.*;
import static ua.training.wizards.form.view.WizardConsoleView.DialogValue.INPUT_SUGGESTION;

class InputOutputSubscriberEntryController {
    private WizardModel model;
    private WizardConsoleView view;

    InputOutputSubscriberEntryController(WizardModel model, WizardConsoleView view) {
        this.model = model;
        this.view = view;
    }

    SubscriberEntry readSubscriberEntry() {
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
                    res = view.readString().trim();
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

    void outputSubscriberEntry(SubscriberEntry subscriberEntry) {
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

    void reInputLogin(SubscriberEntry subscriberEntry) {
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
