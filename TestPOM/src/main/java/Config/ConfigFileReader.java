package Config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "src/main/resources/config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath() {
        String driverPath = properties.getProperty("chromedriverpath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("Chrome driver path not specified in the Configuration.properties file.");
    }

    public String getURL() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }
}
