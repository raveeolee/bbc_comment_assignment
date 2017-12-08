package com.bbc.pages.comment;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Represents page in anonymous state.
 */
public interface CommentsAnonymousState {
    WebElement signInButton();
    WebElement registerButton();
    void openSignInPage();
    List<Comment> comments();
}
