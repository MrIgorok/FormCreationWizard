package ua.training.utils.management.resource;

import java.util.Locale;

/**
 * This class is a factory to create PropertiesFileResource.
 * @see PropertiesFileResource
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public class PropertiesFileResourceFactory implements ResourceFactory {
    private String resourceName;

    /**
     * Deleted default constructor.
     */
    private PropertiesFileResourceFactory() { }

    /**
     * Private Constructor constructs factory with specific resource file name.
     * @param resourceName file name.
     */
    private PropertiesFileResourceFactory(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * Factory method returns instance of this class with specific resource file name.
     * @param resourceName file name.
     * @return Reference to this class.
     */
    public static ResourceFactory getResourceManagerFactory(String resourceName) {
        return new PropertiesFileResourceFactory(resourceName);
    }

    /**
     * Returns Resource for this locale and specific resource file name.
     * @param locale specified locale.
     * @return Resource.
     */
    @Override
    public Resource getResourceManager(Locale locale) {
        return new PropertiesFileResource(resourceName, locale);
    }
}
