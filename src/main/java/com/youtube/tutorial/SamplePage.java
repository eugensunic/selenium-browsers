package com.youtube.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SamplePage {
    WebDriver driver;

    public void OpenChrome() {
        WebDriverConfigurator webDriverConfigurator = new WebDriverConfigurator();
        this.driver = webDriverConfigurator.initializeWebDriver();

        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
    }

    private void clickLoginButton() {
        driver.findElement(By.id("open-login")).click();
    }

    private void navigateToPage(String url) {
        driver.get(url);
    }

    public void NavigateToLandingPageAndOpenLogin() {
        OpenChrome();
        navigateToPage("http://www.coffeetocup.com");
        clickLoginButton();
    }
}