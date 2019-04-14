package ua.training.utils.management.localization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class LocalizationPropertiesLoader {
    private final String propertiesFilePath = "localization/localization.properties";
    private final String xmlPropertiesFilePath = "localization/localization.xml";
    private Properties properties;
    private boolean isResourceSpecified;

    LocalizationPropertiesLoader() {
        properties = new Properties();
        loadResource(propertiesFilePath);
        loadResource(xmlPropertiesFilePath);
    }

    private void loadResource(String resourceName) {
        InputStream in = getResourceInputStream(resourceName);

        if (in != null) {
            loadResourceByStream(in, resourceName);
            isResourceSpecified = true;
        } else {
            isResourceSpecified = false;
        }
    }

    private InputStream getResourceInputStream(String resourceName) {
        ClassLoader classLoader = Localization.class.getClassLoader();
        return classLoader.getResourceAsStream(resourceName);
    }

    private void loadResourceByStream(InputStream in, String resourceName) {
        try {
            properties.load(in);
        } catch (IOException | IllegalArgumentException e) {
            throw new BadPropertiesFormatException("Can't load properties file: " + resourceName);
        }
    }

    public Properties getProperties() {
        if (!isResourceSpecified) {
            throw new NonexistentPropertiesException("Properties files are not specified.");
        }

        return properties;
    }
}
