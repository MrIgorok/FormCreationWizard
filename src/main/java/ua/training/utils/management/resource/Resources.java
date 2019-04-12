package ua.training.utils.management.resource;

import java.util.Locale;

public interface Resources {
    ResourceManager getResource(Locale locale);
    void addResource(ResourceManagerFactory resource);
}
