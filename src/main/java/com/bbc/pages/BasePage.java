package com.bbc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by oleh on 07/12/17.
 */
public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
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

    protected void waitUntil(String message, Supplier<Boolean> waitPredicate) {
        new FluentWait<>(this)
                .withMessage(message)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(it -> waitPredicate.get());
    }
}
