package ua.training.utils.management.localization;

import ua.training.utils.management.resource.ResourceManager;

import java.util.Map;

public class Language {
    private LanguageProperties properties;
    private Map<ResourceManager.ResourceIdentifier, ResourceManager> resources;

    public Language() {

    }

    public Language(String xmlPropertiesFileName) {

    }
}
