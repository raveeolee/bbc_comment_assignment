package com.bbc.pages.comment;

import com.bbc.pages.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of article comment section module.
 */
public class ArticleCommentsSection extends BaseView implements CommentsAnonymousState, CommentsLoggedState {
    private WebDriver driver;

    public ArticleCommentsSection(WebDriver driver) {
        super(driver);
        waitUntil("Page never finished loading",      () -> $("#iframe-loader[style*='none']"));
        waitUntil("Cannot switch to comments iframe", () -> driver.switchTo().frame("bbc-blogs-comments-iframe"));
    }

    public WebElement signInButton() {
        return $(".blogs-comments [class*='cta-signin']");
    }

    public WebElement registerButton() {
        return $(".cmts-header [class*='cta-register']");
    }

    public void openSignInPage() {
        waitUntil("Sign in button does not appear on the Article Page", () -> $(".cmts-list").isDisplayed());
        scrollIntoView(signInButton());
        signInButton().click();
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

    public CommentsLoggedState enterComment(String comment) {
        waitUntil("Comment area was not displayed", () -> commentTextAreaBox().isDisplayed());
        scrollIntoView(commentTextAreaBox());
        commentTextAreaBox().sendKeys(comment);
        return this;
    }

    public CommentsLoggedState postComment() {
        submitButton().click();
        return this;
    }

    public List<Comment> comments() {
        return $$("li.cmt-normal").stream().map(Comment::new).collect(Collectors.toList());
    }

    public CommentsAnonymousState anonymousState() {
        return this;
    }

    public CommentsLoggedState loggedState() {
        return this;
    }

}