package ua.training.utils.management.localization;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

public class LanguagePropertiesSaxParser extends DefaultHandler {
    private static final String LANGUAGE_PROPERTIES_TAG = "languageProperties";
    private static final String LANGUAGE_TAG = "language";
    private static final String COUNTRY_TAG = "country";
    private static final String VARIANT_TAG = "variant";
    private static final String OPTIONS_TAG = "properties";
    private static final String OPTION_TAG = "property";
    private static final String NAME_ATTR = "name";
    private String value;
    private String language = "";
    private String country = "";
    private String variant = "";
    private String entryKey;

    private Locale locale;
    private LanguageProperties languageProperties;


    void parseLanguageProperties(String xmlPropertiesFileName) {
        languageProperties = new LanguageProperties();
        try {
            File xmlPropertiesDocument = Paths.get(xmlPropertiesFileName).toFile();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(xmlPropertiesDocument, this);
        } catch (SAXException | IOException | PatternSyntaxException
                |ParserConfigurationException e) {

        }
    }

    void parseLanguageProperties(InputStream xmlPropertiesInputStream) {
        languageProperties = new LanguageProperties();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(xmlPropertiesInputStream, this);
        } catch (SAXException | IOException | PatternSyntaxException
                |ParserConfigurationException e) {

        }
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, Attributes attrs) throws SAXException {
        switch (qualifiedName) {
            case LANGUAGE_PROPERTIES_TAG:
                break;
            case LANGUAGE_TAG:
                break;
            case COUNTRY_TAG:
                break;
            case VARIANT_TAG:
                break;
            case OPTIONS_TAG:
                break;
            case OPTION_TAG:
                for (int i = 0; i < attrs.getLength(); i++) {
                    switch (attrs.getLocalName(i)) {
                        case NAME_ATTR:
                            entryKey = attrs.getValue(i);
                            break;
                    }
                }
                break;
            default:
                throw new SAXException("Wrong open tag");

        }
    }

    @Override
    public void characters(char [] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String namespaceURI, String localName,
                           String qualifiedName) throws SAXException {
        switch (qualifiedName) {
            case LANGUAGE_PROPERTIES_TAG:
                locale = new Locale(language, country, variant);
                break;
            case LANGUAGE_TAG:
                language = value;
                break;
            case COUNTRY_TAG:
                country = value;
                break;
            case VARIANT_TAG:
                variant = value;
                break;
            case OPTIONS_TAG:
                break;
            case OPTION_TAG:
                languageProperties.addProperty(entryKey, value);
                break;
            default:
                throw new SAXException("Wrong closed tag");
        }
    }


    public Locale getLocale() {
        return locale;
    }

    public LanguageProperties getLanguageProperties() {
        return languageProperties;
    }
}
