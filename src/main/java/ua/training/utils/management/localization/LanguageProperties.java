package ua.training.utils.management.localization;

import java.util.HashMap;
import java.util.Map;

public class LanguageProperties {
    private Map<String, String> propertyValueMap;

    LanguageProperties() {
        this.propertyValueMap = new HashMap<>();
    }

    void addProperty(String key, String value) {
        propertyValueMap.put(key, value);
    }

    public String getPropertyValue(String property) {
        return propertyValueMap.get(property);
    }
}
