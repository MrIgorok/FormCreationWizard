package ua.training.utils.management.resource;

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

    private static final Object mutex = new Object();

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
     * Returns ResourceManager for specific locale.
     * Method is thread safe.
     * @param locale specific locale.
     * @return value.
     */
    public ResourceManager getResourceManager(Locale locale) {
        if (!resources.containsKey(locale)) {
            synchronized (mutex) {
                resources.put(locale, factory.getResourceManager(locale));
            }
        }

        return resources.get(locale);
    }
}
