package ua.training.utils.management.resource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class controls one resource with different locales.
 * This class contains set of singleton Resource.
 * Each locale is mapping to one Resource.
 *
 * @see Resource
 * @see ResourceFactory
 * @version 1.0 Apr 08 2019
 * @author  Igor Klapatnjuk
 */
public class ResourceLocalizationManager {
    private Map<Locale, Resource> resources = new HashMap<>();
    private ResourceFactory factory;

    private static final Object mutex = new Object();

    /**
     * Creates ResourceLocalizationManager with specific resource name
     * and ResourceFactory.
     * @see ResourceFactory
     * @param factory Factory that creates Resource.
     */
    public ResourceLocalizationManager(ResourceFactory factory) {
        this.factory = factory;
    }

    /**
     * Returns Resource for specific locale.
     * Method is thread safe.
     * @param locale specific locale.
     * @return value.
     */
    public Resource getResourceManager(Locale locale) {
        if (!resources.containsKey(locale)) {
            synchronized (mutex) {
                resources.put(locale, factory.getResourceManager(locale));
            }
        }

        return resources.get(locale);
    }
}
