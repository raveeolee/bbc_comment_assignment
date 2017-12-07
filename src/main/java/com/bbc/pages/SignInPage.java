package com.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oleh on 07/12/17.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement emailInput() {
        return $("#user-identifier-input");
    }

    public WebElement passwordInput() {
        return $("#password-input");
    }

    public WebElement signInButton() {
        return $("#submit-button");
    }

    public ArticlePage signIn(String email, String password) {
        waitUntil("Email field does not appear on Sing In Page", () -> emailInput().isDisplayed());
        emailInput().sendKeys(email);
        passwordInput().sendKeys(password);
        signInButton().click();
        return new ArticlePage(driver());
    }
}
