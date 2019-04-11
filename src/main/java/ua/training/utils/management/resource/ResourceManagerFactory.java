package ua.training.utils.management.resource;

import java.util.Locale;

/**
 * ResourceManager factory.
 * @see ResourceManager
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public interface ResourceManagerFactory {
    /**
     * Returns specific resource manager.
     * @param locale specified locale.
     * @return ResourceManager.
     * @see ResourceManager
     */
    ResourceManager getResourceManager(Locale locale);
}
