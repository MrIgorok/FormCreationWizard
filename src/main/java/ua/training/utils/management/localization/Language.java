package ua.training.utils.management.localization;

import ua.training.utils.management.resource.LocaleResources;
import ua.training.utils.management.resource.PropertyFilesLocaleResources;
import ua.training.utils.management.resource.Resource;

import java.io.InputStream;
import java.util.Locale;

public class Language {
    private Locale locale;
    private LanguageProperties properties;
    private LocaleResources resources;

    Language(Locale locale, LanguageProperties properties) {
        this.locale = locale;
        this.properties = properties;
        this.resources = new PropertyFilesLocaleResources();
    }

    Language(String xmlPropertiesFileName) {
        LanguagePropertiesSaxParser propertiesParsing = new LanguagePropertiesSaxParser();
        propertiesParsing.parseLanguageProperties(xmlPropertiesFileName);

        locale = propertiesParsing.getLocale();
        properties = propertiesParsing.getLanguageProperties();
    }

    Language(InputStream xmlPropertiesInputStream) {
        LanguagePropertiesSaxParser parser = new LanguagePropertiesSaxParser();
        parser.parseLanguageProperties(xmlPropertiesInputStream);

        locale = parser.getLocale();
        properties = parser.getLanguageProperties();
    }

    public final Locale getLocale() {
        return locale;
    }

    public final LanguageProperties getProperties() {
        return properties;
    }

    public final LocaleResources getResources() {
        return resources;
    }

    void addResource(Resource resource) {
        this.resources.addResource(resource);
    }
}
