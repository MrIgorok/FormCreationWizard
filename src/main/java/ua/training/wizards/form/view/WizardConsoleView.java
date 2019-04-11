package ua.training.wizards.form.view;

import ua.training.utils.management.ResourceLocalizationManager;
import ua.training.utils.management.resource.PropertyResourceBundleManagerFactory;
import ua.training.utils.management.resource.ResourceManagerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class provides user interface by using streams.
 * This class require InputStream and OutputStream that
 * will used for input and output user information.
 *
 * @see WizardView
 * @see OutputStream
 * @see InputStream
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class WizardConsoleView {
    private PrintStream outputWriter;
    private Scanner inputReader;
    private ResourceLocalizationManager stringLocalizationManager;
    private Locale resourceLocale;

    public Locale getResourceLocale() {
        return resourceLocale;
    }

    public void setResourceLocale(Locale resourceLocale) {
        this.resourceLocale = resourceLocale;
    }

    /**
     * Values that require for user interface
     */
    public enum DialogValue {
        WELCOME_MESSAGE,
        LANGUAGE_CHOSE_SUGGESTION,
        INPUT_SUGGESTION,
        WRONG_INPUT
    }
    /**
     * Creates view.
     * @param outputStream output stream that will be used for user input.
     * @param inputStream input stream that will be used for input.
     * @param propertyResourceFileName property resource file name.
     */
    public WizardConsoleView(OutputStream outputStream,
                             InputStream inputStream, String propertyResourceFileName) {
        outputWriter = new PrintStream(outputStream);
        inputReader = new Scanner(inputStream);

        ResourceManagerFactory factory =
                PropertyResourceBundleManagerFactory.getResourceManagerFactory(propertyResourceFileName);
        stringLocalizationManager = new ResourceLocalizationManager(factory);
    }

    /**
     * Print the message and align text.
     * @param message the message that will be printed
     */
    public void printMessage(String message) {
        outputWriter.print(message);
    }

    /**
     * Reads the string.
     * @return the read string.
     */
    public String readString() {
        return inputReader.next();
    }

    /**
     * Gets standard dialog value and set format value.
     * @param key type of value that will be returned
     * @param formatValueArguments strings that will be used in format
     * @return value associated with {@link DialogValue}
     */
    private String getDialogValueAndSetFormatValue(DialogValue key, String ... formatValueArguments) {
        String resourceValue = stringLocalizationManager.getValue(key.name(), resourceLocale);

        if (formatValueArguments.length > 0) {
            resourceValue = String.format(resourceValue, formatValueArguments);
        }

        return resourceValue;
    }
}
