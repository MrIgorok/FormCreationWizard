package ua.training.utils.management.resource;

/**
 * This interface consists of resource management methods.
 *
 * @version 1.0 04 Apr 2019
 * @author  Igor Klapatnjuk
 */
interface ResourceManager {
    /**
     * Returns the value related to the key.
     * @param key key which value will be returned.
     * @return value.
     */
    String getValue(String key);

    /**
     *
     */
    String getURIResourceName();
}
