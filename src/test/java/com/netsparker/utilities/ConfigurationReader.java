package com.netsparker.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {


    //This reader is used to read frequently used data(url, username password etc) from configuration properties
    //so that maintenance of our framework is easier, all data are stored in a central location.
    //Methods, code blocks etc. are static so that I can call it without creating object from this class
    private static Properties properties;
    static {
        try {
            // file to read
            String path = "configuration.properties";
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
