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
    /**
     * Map of resources. Each locale has its own ResourceManager.
     */
    private static Map<Locale, ResourceManager> resources = new HashMap<>();

    /**
     * Factory that creates ResourceManager.
     * @see ResourceManagerFactory
     */
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
     * Gets ResourceManager for a specific locale.
     * @param locale locale which ResourceManager will be returned.
     * @return ResourceManager
     */
    public ResourceManager getResourceManager(Locale locale) {
        if (!resources.containsKey(locale)) {
            resources.put(locale, factory.getResourceManager(locale));
        }

        return resources.get(locale);
    }
}
