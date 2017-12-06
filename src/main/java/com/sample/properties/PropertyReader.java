package com.sample.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

  public static String getProperty(String key) {
    String env = System.getProperty("env");
    Properties properties = new Properties();
    InputStream inputStream = PropertyReader.class.getResourceAsStream("/" + env + ".properties");
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties.getProperty(key);
  }
}
