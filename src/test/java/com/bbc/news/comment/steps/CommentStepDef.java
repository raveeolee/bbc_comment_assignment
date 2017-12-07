package com.bbc.news.comment.steps;

import com.bbc.news.runner.BaseStepDef;
import com.bbc.pages.comment.ArticleCommentsSection;
import com.bbc.pages.RegisterBbcPage;
import com.bbc.pages.SignInPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import java.time.LocalDateTime;

/**
 * Comment section step definitions.
 */
public class CommentStepDef extends BaseStepDef {

    private String rndCommentMessage = "Comment " + RandomStringUtils.randomAlphanumeric(20) + ", " + LocalDateTime.now() + "!";

    public CommentStepDef() {

        Given("^I navigate to: '(.*)'$", (String url) ->
            driver().navigate().to(url)
        );

        Given("^I login as audience member with email '(.*)' and password '(.*)'$", (String email, String pass) -> {
            new ArticleCommentsSection(driver()).anonymousState().openSignInPage();
            new SignInPage(driver()).signIn(email, pass);
        });

        And("^I post some comment$", () -> {
            new ArticleCommentsSection(driver()).loggedState().enterComment(rndCommentMessage).postComment();
        });

        Then("^message '(.*)' appears$", (String message) -> {
            String text = new ArticleCommentsSection(driver()).loggedState().waitForCommentsMessage().getText();
            Assert.assertEquals("Comments message is wrong", text, message);
        });

        And("^comment appears in comments list with with author '(.*)'$", (String author) -> {
            new ArticleCommentsSection(driver()).loggedState().comments().stream()
                    .filter(comment -> comment.text().getText().equals(rndCommentMessage))
                    .filter(comment -> comment.author().getText().equals(author))
                    .findFirst().orElseThrow(() ->
                        new AssertionError(String.format("Comment not found. Text: [%s], Author: [%s]", rndCommentMessage, author)));
        });

        When("^I click Register link in comments section$", () -> {
            new ArticleCommentsSection(driver()).anonymousState().registerButton().click();
        });

        Then("^I redirected to '(.*)' page$", (String expTitle) -> {
            String actTitle = new RegisterBbcPage(driver()).title().getText();
            Assert.assertEquals("Wrong page opened", expTitle, actTitle);
        });
    }
}
