package ua.training.wizards.form.model;

import ua.training.utils.management.resource.PropertiesFileResource;
import ua.training.utils.management.resource.Resource;

import java.util.Locale;

class Validator {
    private String propertiesResourceBundleFile;
    private Resource regexResource;

    Validator(String propertiesResourceBundleFile) {
        this.propertiesResourceBundleFile = propertiesResourceBundleFile;
        regexResource = new PropertiesFileResource(propertiesResourceBundleFile, Locale.getDefault());
    }

    boolean validate(String fieldName, String validatedValue) {
        String regex = regexResource.getValue(fieldName.toUpperCase());

        return validatedValue.matches(regex);
    }

    void setValidationLocale(Locale locale) {
        regexResource = new PropertiesFileResource(propertiesResourceBundleFile, locale);
    }
}
