package ua.training.utils.management;

import ua.training.utils.management.resource.ResourceManager;
import ua.training.utils.management.resource.ResourceManagerFactory;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class controls one resource with different locales.
 * This class contains set of singleton ResourceManager.
 * Each locale is mapping to one ResourceManager.
 *
 * @see ResourceManager
 * @see ResourceManagerFactory
 * @version 1.0 Apr 08 2019
 * @author  Igor Klapatnjuk
 */
public class ResourceLocalizationManager {
    private Map<Locale, ResourceManager> resources = new HashMap<>();
    private ResourceManagerFactory factory;

    /**
     * Creates ResourceLocalizationManager with specific resource name
     * and ResourceManagerFactory.
     * @see ResourceManagerFactory
     * @param factory Factory that creates ResourceManager.
     */
    public ResourceLocalizationManager(ResourceManagerFactory factory) {
        this.factory = factory;
    }

    /**
     * Returns the value related to the key and for specific locale.
     * @param key key which value will be returned.
     * @return value.
     */
    public String getValue(String key, Locale locale) {
        if (!resources.containsKey(locale)) {
            resources.put(locale, factory.getResourceManager(locale));
        }

        return resources.get(locale).getValue(key);
    }
}
