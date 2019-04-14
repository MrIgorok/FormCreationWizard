package ua.training.utils.management.localization;

import ua.training.utils.management.resource.*;

import java.util.*;

public class Localization {
    private static Properties localizationProperties;
    private static Map<Locale, Language> languages;
    private static Map<String, ResourceLocalizationManager> nameResourceProducerMap;

    static {
        //TODO: declaration properties by annotation;
        localizationProperties = new LocalizationPropertiesLoader().getProperties();

        languages = LanguagesPropertiesFilesLoader.load(localizationProperties);

        //TODO: resources initialization
        nameResourceProducerMap = new HashMap<>();
    }

    public static LanguageProperties getLanguageProperties(Locale locale) {
        return getLanguageByLocale(locale).getProperties();
    }

    public static LocaleResources getLanguageResources(Locale locale) {
        return getLanguageByLocale(locale).getResources();
    }

    private static Language getLanguageByLocale(Locale locale) {
        Language language = languages.get(locale);

        if (language == null) {
            throw new NonexistentResourceException("This language is not supported.");
        }

        return language;
    }

    public static void addResource(String resourcePath) {
        if (nameResourceProducerMap.keySet().contains(resourcePath)) return;

        ResourceFactory resourceFactory = PropertiesFileResourceFactory.getResourceManagerFactory(resourcePath);
        ResourceLocalizationManager localizationManager = new ResourceLocalizationManager(resourceFactory);
        loadResourceInLanguages(localizationManager);

        nameResourceProducerMap.put(resourcePath, localizationManager);
    }

    private static void loadResourceInLanguages(ResourceLocalizationManager localizationManager) {
        languages.forEach((locale, language) -> {
            language.addResource(localizationManager.getResourceManager(locale));
        });
    }
}
