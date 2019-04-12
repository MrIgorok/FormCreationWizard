package ua.training.utils;

import java.util.Locale;
import java.util.Map;

public class LanguageProperties {
    private Locale locale;
    private Map<String, String> propertyValueMap;

    public LanguageProperties(String xmlPropertiesFileName) {
        new Locale()
    }

    public LanguageProperties(Locale locale, Map<String, String> propertyValueMap) {
        this.locale = locale;
        this.propertyValueMap = propertyValueMap;
    }

    public String getOptionValue(String option) {
        return optionValueMap.get(option);
    }
}
