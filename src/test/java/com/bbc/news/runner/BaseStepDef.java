package com.bbc.news.runner;

import cucumber.api.java8.En;
import env.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by oleh on 07/12/17.
 */
public class BaseStepDef implements En {

    private WebDriver driver;

    public BaseStepDef() {
        Before(this::openBrowser);
        After (this::killBrowser);
    }

    protected void openBrowser() {
        driver = new BrowserFactory(FirefoxDriver::new)
                .setJavascript(true)
                .setMaximizeWindowOnStart(true)
                .setBrowserTimeout(TimeUnit.SECONDS, 20)
                .setDriverPath("webdriver.gecko.driver", "/home/oleh/geckodriver/geckodriver") // Path to driver
                .build();
    }

    protected void killBrowser() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Issue with closing driver:\n" + e);
        }
    }

    protected WebDriver driver() {
        return driver;
    }
}
