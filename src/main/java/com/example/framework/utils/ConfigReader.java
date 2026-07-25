package com.example.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader(String fileName) {
        this.properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IllegalArgumentException("Unable to find config file: " + fileName);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file: " + fileName, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
