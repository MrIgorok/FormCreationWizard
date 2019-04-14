package ua.training;

import ua.training.wizards.form.controller.WizardController;
import ua.training.wizards.form.model.WizardModel;
import ua.training.wizards.form.view.WizardConsoleView;

/**
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class Main {

    public static void main(String [] args) {
        WizardModel model = new WizardModel();
        WizardConsoleView view = new WizardConsoleView(System.out, System.in, "string");
        WizardController controller = new WizardController(model, view);

        model.createNewSubscriberEntry();
    }
}
