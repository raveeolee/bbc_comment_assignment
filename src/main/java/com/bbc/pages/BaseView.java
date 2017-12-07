package com.bbc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by oleh on 07/12/17.
 */
public abstract class BaseView {
    private WebDriver driver;

    public BaseView(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement $(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    protected List<WebElement> $$(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector));
    }

    protected WebElement $x(String xpathSelector) {
        return driver.findElement(By.xpath(xpathSelector));
    }

    protected WebDriver driver() {
        return driver;
    }

    protected <T> T waitUntil(String message, Supplier<T> waitPredicate) {
        return new FluentWait<>(this)
                .withMessage(message)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(WebDriverException.class)
                .until(it -> waitPredicate.get());
    }

    protected void scrollIntoView(WebElement webElement) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        }
    }
}
