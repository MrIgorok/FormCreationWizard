package ua.training.utils.management.resource;

import java.util.Locale;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * This class consists of external resource management methods.
 * The PropertyResourceBundle is used for managing resources.
 * This class is permanent you can't change it after specified resource file and locale.
 * This class is final so you can't inherit it.
 *
 * @see PropertyResourceBundle
 * @see ResourceManager
 *
 * @version 1.0 08 Apr 2019
 * @author  Igor Klapatnjuk
 */
public final class PropertyResourceBundleManager implements ResourceManager {

    private ResourceBundle resourceBundle;

    /**
     * Deleted default constructor.
     */
    private PropertyResourceBundleManager() {

    }

    /**
     * Creates PropertyResourceBundleManager.
     * Resource file and locale must be specified and can't be null.
     * If one of them is null NullPointerException will be thrown.
     * @see NullPointerException
     * @param resourceName the file name that contains resource.
     * @param locale locale that is used.
     */
    public PropertyResourceBundleManager(final String resourceName, final Locale locale) {
        resourceBundle = PropertyResourceBundle.getBundle(resourceName, locale);
    }

    /**
     * Returns the key value for a specified locale.
     * If value doesn't contain for the specified locale,
     * return the next most appropriate value.
     * @param key key which value will be returned.
     * @return value
     */
    @Override
    public String getValue(final String key) {
        return resourceBundle.getString(key);
    }

    /**
     * Returns the resource name.
     * @return resource name.
     */
    @Override
    public String getURIResourceName() {
        return resourceBundle.getBaseBundleName();
    }

    /**
     * Returns the locale that uses this resource.
     * @return locale
     */
    public Locale getLocale() {
        return resourceBundle.getLocale();
    }
}
