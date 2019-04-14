package ua.training.utils.management.resource;

public interface LocaleResources {
    String getValue(String resourceIdentifier, String key);

    void addResource(Resource resource);
}
