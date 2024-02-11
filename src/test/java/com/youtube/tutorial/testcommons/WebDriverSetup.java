package com.youtube.tutorial.testcommons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverSetup {

    public static void setup() {
        Properties properties = loadProperties();

        String os = System.getProperty("os.name");

        if (isWindows(os)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver.path.windows"));
            System.setProperty("webdriver.chrome.binary", properties.getProperty("chromedriver.binary.windows"));
        } else if (isMac(os)) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver.path.mac"));
            System.setProperty("webdriver.chrome.binary", properties.getProperty("chromedriver.binary.mac"));
        }
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/webdriver.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static boolean isWindows(String os) {
        return os.toLowerCase().contains("win");
    }

    private static boolean isMac(String os) {
        return os.toLowerCase().contains("mac");
    }
}
