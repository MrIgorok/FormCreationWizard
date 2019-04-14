package ua.training.utils.management.localization;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

//TODO: rewrite this
class LanguagesPropertiesFilesLoader {

    private LanguagesPropertiesFilesLoader() {

    }

    static Map<Locale, Language> load(Properties localizationProperties) {
        String configsDirectory =
                localizationProperties.getProperty("defaultDirectory", "localization");

        String [] files = getResourcesFilesInDirectory(configsDirectory);

        return readLanguagePropertiesFiles(files);
    }

    private static String [] getResourcesFilesInDirectory(String path) {
        Class thisClass = LanguagesPropertiesFilesLoader.class;
        URL dirURL = thisClass.getClassLoader().getResource(path);

        try {
            if (dirURL != null && dirURL.getProtocol().equals("file")) {
                return new File(dirURL.toURI()).list();
            }

            if (dirURL == null) {
                String me = thisClass.getName().replace(".", "/") + ".class";
                dirURL = thisClass.getClassLoader().getResource(me);
            }

            if (dirURL.getProtocol().equals("jar")) {
                String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!"));
                JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
                Enumeration<JarEntry> entries = jar.entries();
                Set<String> result = new HashSet<String>();
                while (entries.hasMoreElements()) {
                    String name = entries.nextElement().getName();
                    if (name.startsWith(path)) {
                        String entry = name.substring(path.length());
                        int checkSubdir = entry.indexOf("/");
                        if (checkSubdir >= 0) {
                            entry = entry.substring(0, checkSubdir);
                        }
                        result.add(entry);
                    }
                }
                return result.toArray(new String[result.size()]);
            }
        } catch (IOException | URISyntaxException e) {
            throw new UnsupportedOperationException("Cannot list files for URL " + dirURL);
        }

        throw new UnsupportedOperationException("Cannot list files for URL " + dirURL);
    }

    private static Map<Locale, Language> readLanguagePropertiesFiles(String [] filesList) {
        Map<Locale, Language> languages = new HashMap<>();
        for (String file : filesList) {
            if (file.matches(".*.xml")) {
                Language language = new Language(LanguagesPropertiesFilesLoader.class.getResourceAsStream(file));
                languages.put(language.getLocale(), language);
            }
        }
        return languages;
    }
}
