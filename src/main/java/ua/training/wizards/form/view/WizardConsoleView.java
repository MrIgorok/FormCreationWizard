package ua.training.wizards.form.view;

import ua.training.utils.management.ResourceLocalizationManager;
import ua.training.utils.management.resource.PropertyResourceBundleManagerFactory;
import ua.training.utils.management.resource.ResourceManagerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
public class WizardConsoleView implements WizardView {
    private PrintStream outputWriter;
    private Scanner inputReader;
    private ResourceLocalizationManager stringLocalizationManager;

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
     *
     */
    void printMessage(String message) {

    }
}
