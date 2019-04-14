package ua.training.utils.management.resource;

import java.util.Locale;

/**
 * Resource factory.
 * @see Resource
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public interface ResourceFactory {
    /**
     * Returns specific resource manager.
     * @param locale specified locale.
     * @return Resource.
     * @see Resource
     */
    Resource getResourceManager(Locale locale);
}
