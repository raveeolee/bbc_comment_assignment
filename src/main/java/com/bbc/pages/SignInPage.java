package com.bbc.pages;

import com.bbc.pages.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Implementation of Sign In Page where users enter their credentials.
 */
public class SignInPage extends BaseView {

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

    /**
     * Login into the application to post comment.
     * @param email
     * @param password
     */
    public void signIn(String email, String password) {
        waitUntil("Email field does not appear on Sing In Page", () -> emailInput().isDisplayed());
        emailInput().sendKeys(email);
        passwordInput().sendKeys(password);
        signInButton().click();
    }
}
