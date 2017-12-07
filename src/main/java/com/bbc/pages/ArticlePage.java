package com.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oleh on 07/12/17.
 */
public class ArticlePage extends BasePage {

    public ArticlePage(WebDriver driver) {
        super(driver.switchTo().frame("bbc-blogs-comments-iframe"));
    }

    public WebElement signInButton() {
        return $(".cmts-header [class*='cta-signin']");
    }

    public SignInPage openSignInPage() {
        waitUntil("Sign in button does not appear on the Article Page", () -> signInButton().isDisplayed());
        signInButton().click();
        return new SignInPage(driver().switchTo().defaultContent());
    }
}
