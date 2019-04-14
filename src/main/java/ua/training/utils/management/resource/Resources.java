package ua.training.utils.management.resource;

import java.util.Locale;

public interface Resources {
    Resource getResource(Locale locale);
    void addResource(ResourceFactory resource);
}
