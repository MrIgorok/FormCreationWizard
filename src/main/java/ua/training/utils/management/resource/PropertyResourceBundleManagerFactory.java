package ua.training.utils.management.resource;

import java.util.Locale;

/**
 * This class is a factory to create PropertyResourceBundleManager.
 * @see PropertyResourceBundleManager
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class PropertyResourceBundleManagerFactory implements ResourceManagerFactory {
    private String resourceName;

    /**
     * Deleted default constructor.
     */
    private PropertyResourceBundleManagerFactory() { }

    /**
     * Private Constructor constructs factory with specific resource file name.
     * @param resourceName file name.
     */
    private PropertyResourceBundleManagerFactory(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * Factory method returns instance of this class with specific resource file name.
     * @param resourceName file name.
     * @return Reference to this class.
     */
    public static ResourceManagerFactory getResourceManagerFactory(String resourceName) {
        return new PropertyResourceBundleManagerFactory(resourceName);
    }

    /**
     * Returns ResourceManager for this locale and specific resource file name.
     * @param locale specified locale.
     * @return ResourceManager.
     */
    @Override
    public ResourceManager getResourceManager(Locale locale) {
        return new PropertyResourceBundleManager(resourceName, locale);
    }
}
