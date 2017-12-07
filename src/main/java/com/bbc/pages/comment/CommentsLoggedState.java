package com.bbc.pages.comment;

import com.bbc.pages.comment.ArticleCommentsSection;
import com.bbc.pages.components.Comment;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Comments section for logged in user.
 */
public interface CommentsLoggedState {
    CommentsLoggedState postComment();
    List<Comment> comments();
    WebElement commentTextAreaBox();
    WebElement submitButton();
    CommentsLoggedState enterComment(String comment);
    WebElement waitForCommentsMessage();
}
