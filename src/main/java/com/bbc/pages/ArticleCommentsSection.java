package com.bbc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Implementation of article comment section module.
 */
public class ArticleCommentsSection extends BaseView {
    private WebDriver driver;

    public ArticleCommentsSection(WebDriver driver) {
        super(driver);
        waitUntil("Cannot switch to comments iframe", () -> driver.switchTo().frame("bbc-blogs-comments-iframe"));
    }

    public WebElement signInButton() {
        return $(".blogs-comments [class*='cta-signin']");
    }

    public SignInPage openSignInPage() {
        waitUntil("Sign in button does not appear on the Article Page", () -> $(".cmts-list").isDisplayed());
        scrollIntoView(signInButton());
        signInButton().click();
        return new SignInPage(driver().switchTo().defaultContent());
    }

    public WebElement commentTextAreaBox() {
        return $("[name='comment']");
    }

    public WebElement submitButton() {
        return $("[type='submit']");
    }

    public WebElement commentsMessage() {
        return $(".cmts-message");
    }

    public WebElement waitForCommentsMessage() {
        return waitUntil("Comments message does not appear", this::commentsMessage);
    }

    public ArticleCommentsSection enterComment(String comment) {
        waitUntil("Comment area was not displayed", () -> commentTextAreaBox().isDisplayed());
        scrollIntoView(commentTextAreaBox());
        commentTextAreaBox().sendKeys(comment);
        return this;
    }

    public ArticleCommentsSection postComment() {
        submitButton().click();
        return this;
    }

}