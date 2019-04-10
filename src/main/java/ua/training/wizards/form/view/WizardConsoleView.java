package ua.training.wizards.form.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Class provides user interface by using streams.
 * This class require InputStream and OutputStream that
 * will used for input and output user information.
 *
 * @see OutputStream
 * @see InputStream
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class WizardConsoleView {
    /**
     * Reads user from specified stream.
     */
    private Scanner readInput;
    /**
     * Output information.
     */
    private PrintStream w;

    /**
     * Creates view.
     * @param outputStream output stream that will be used for user input.
     * @param inputStream input stream that will be used for input.
     */
    public WizardConsoleView(OutputStream outputStream, InputStream inputStream, ResourceManager) {

    }

    /**
     *
     */
    void printMessage(String message)+
}
