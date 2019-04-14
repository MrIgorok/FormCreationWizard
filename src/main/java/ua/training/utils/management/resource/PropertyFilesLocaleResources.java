package ua.training.utils.management.resource;

import java.util.HashMap;
import java.util.Map;

public class PropertyFilesLocaleResources implements LocaleResources {
    private Map<String, Resource> identifierResourceMap = new HashMap<>();

    public PropertyFilesLocaleResources() {

    }

    @Override
    public String getValue(String resourceIdentifier, String key) {
        Resource resource = identifierResourceMap.get(resourceIdentifier);

        if (resource == null) {
            throw new NonexistentResourceException("This language is not supported.");
        }

        return resource.getValue(key);
    }

    @Override
    public void addResource(Resource resource) {
        identifierResourceMap.put(resource.getURIResourceName(), resource);
    }
}
