package com.bbc.news.comment.steps;

import com.bbc.news.runner.BaseStepDef;
import com.bbc.pages.ArticleCommentsSection;
import env.RandomSentenceGenerator;
import org.junit.Assert;

/**
 * Comment section step definitions.
 */
public class CommentStepDef extends BaseStepDef {

    public CommentStepDef() {

        Given("^I navigate to: '(.*)'$", (String url) -> {
            driver().navigate().to(url);
        });

        Given("^I login as audience member with email '(.*)' and password '(.*)'$", (String email, String pass) -> {
            new ArticleCommentsSection(driver())
                    .openSignInPage()
                    .signIn(email, pass);
        });

        And("^I post some comment$", () -> {
            String message = new RandomSentenceGenerator().generateSentence(10);
            new ArticleCommentsSection(driver()).enterComment(message).postComment();
        });

        Then("^message '(.*)' appears$", (String message) -> {
            String text = new ArticleCommentsSection(driver()).waitForCommentsMessage().getText();
            Assert.assertEquals("Comments message is wrong", text, message);
        });
    }
}
