package com.bbc.pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Common view logic.
 */
public abstract class BaseView {
    private SearchContext searchContext;

    public BaseView(SearchContext context) {
        this.searchContext = context;
    }

    /**
     * jQuery style selector methods. The idea is that user can copy paste the method in DevTools of browser and it will resolve a web element.
     * @param cssSelector - valid css selector
     * @return WebElement found by specified selector
     */
    protected WebElement $(String cssSelector) {
        return context().findElement(By.cssSelector(cssSelector));
    }

    /**
     * jQuery style selector methods. The idea is that user can copy paste the method in DevTools of browser and it will resolve a web element.
     * @param cssSelector - valid css selector
     * @return List of WebElements
     */
    protected List<WebElement> $$(String cssSelector) {
        return searchContext.findElements(By.cssSelector(cssSelector));
    }

    /**
     * jQuery style selector methods. The idea is that user can copy paste the method in DevTools of browser and it will resolve a web element.
     * @param xpathSelector - valid xpath selector
     * @return WebElement by specified xpath selector
     */
    protected WebElement $x(String xpathSelector) {
        return context().findElement(By.xpath(xpathSelector));
    }

    /**
     * Search context - can be either WebDriver, WebElement. This enables a convenient way to to provide scope, eq where to search.
     * Like on a page, inside the WebElement etc.
     * @return SearchContext
     */
    protected SearchContext context() {
        return searchContext;
    }

    /**
     * Waits until specficied condition is either not null or true.
     * @param message - message to be posted in case condition is not met
     * @param waitPredicate - condition
     * @param <T> - type
     * @return T
     */
    protected <T> T waitUntil(String message, Supplier<T> waitPredicate) {
        return new FluentWait<>(this)
                .withMessage(message)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(WebDriverException.class)
                .until(it -> waitPredicate.get());
    }

    /**
     * Executes Javascript snippet if possible.
     * @param webElement
     */
    protected void scrollIntoView(WebElement webElement) {
        if (searchContext instanceof JavascriptExecutor) {
            ((JavascriptExecutor) context()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        }
    }
}
