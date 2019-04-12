package ua.training.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.PatternSyntaxException;

public class LanguagePropertiesSaxParsing extends DefaultHandler {
    private static final String LANGUAGE_TAG = "language";
    private static final String COUNTRY_TAG = "country";
    private static final String VARIANT_TAG = "variant";
    private static final String OPTIONS_TAG = "properties";
    private static final String OPTION_TAG = "property";
    private LanguageProperties languageProperties;


    public LanguageProperties parseLanguageProperties(String xmlPropertiesFileName) {
        try {
            File xmlPropertiesDocument = Paths.get(xmlPropertiesFileName).toFile();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(xmlPropertiesDocument, this);
        } catch (SAXException | IOException | PatternSyntaxException
                |ParserConfigurationException e) {

        }
    }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, Attributes attrs) throws SAXException {
        switch (qualifiedName) {
            case LANGUAGE_TAG:
                break;
            case COUNTRY_TAG:
                break;
            case VARIANT_TAG:
                break;
            case OPTIONS_TAG:
                break;
            case OPTION_TAG:

        }
    }
}
