package com.youtube.tutorial;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class WebDriverConfigurator {

    protected ChromeOptions chromeOptions;

    public WebDriverConfigurator() {
        this.chromeOptions = new ChromeOptions();
        setupChromeOptions();
    }

    private boolean isRemoteServerExecution(String os) {
        String remoteExecution = System.getProperty("REMOTE_EXECUTION");
        return !(os.toLowerCase().contains("win") || os.toLowerCase().contains("mac"))
                || "true".equalsIgnoreCase(remoteExecution);
    }

    protected void setupChromeOptions() {
        String binary = System.getProperty("webdriver.chrome.binary", null);
        chromeOptions.addArguments("--remote-allow-origins=*");
        if (binary != null) {
            chromeOptions.setBinary(binary);
        }

        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            throw new RuntimeException("Headless mode is not supported.");
        }

        chromeOptions.setExperimentalOption("prefs", Map.of("intl.accept_languages", "de-DE"));

        if (!Boolean.parseBoolean(System.getProperty("ignoreProxySettings", "false"))) {
            Proxy proxy = new Proxy();
            String proxyHost = System.getProperty("webdriver.proxy.host");
            proxy.setHttpProxy(proxyHost);
            proxy.setSslProxy(proxyHost);
            proxy.setNoProxy(System.getProperty("webdriver.proxy.noProxyList"));
            chromeOptions.setCapability(CapabilityType.PROXY, proxy);
        }
    }

    public WebDriver initializeWebDriver() {
        String os = System.getProperty("os.name");
        WebDriver driver = new ChromeDriver(this.chromeOptions);

        if (isRemoteServerExecution(os)) {
            System.out.println("Remote server execution... ");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("goog:chromeOptions", chromeOptions);
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.LINUX);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                return driver;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize the WebDriver due to malformed URL", e);
            }
        } else {
            // local execution browser setup (no container)
            System.out.println("Local execution... " + os);
            return driver;
        }

    }
}
