package com.bbc.news.base;

import cucumber.api.java8.En;
import env.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Base steps logic. WebDriver configuration.
 */
public class BaseStepDef implements En {

    private WebDriver driver;

    public BaseStepDef() {
        Before(this::openBrowser);
        After (this::killBrowser);
    }

    /**
     * Opens browser.
     */
    protected void openBrowser() {
        this.driver = new BrowserFactory(FirefoxDriver::new)
                .setJavascript(true)
                .setMaximizeWindowOnStart(true)
                .setBrowserTimeout(TimeUnit.SECONDS, 30)
                .setDriverPath("webdriver.gecko.driver", System.getProperty("user.home") + "/geckodriver/geckodriver") // Path to driver exec
                .build();
    }

    /**
     * Closes browser.
     */
    protected void killBrowser() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Issue with closing driver:\n");
            e.printStackTrace();
            throw e;
        }
    }

    protected WebDriver driver() {
        return driver.switchTo().defaultContent();
    }
}
