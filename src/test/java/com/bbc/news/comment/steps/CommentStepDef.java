package com.bbc.news.comment.steps;

import com.bbc.news.runner.BaseStepDef;
import com.bbc.pages.ArticlePage;

/**
 * Created by oleh on 07/12/17.
 */
public class CommentStepDef extends BaseStepDef {

    public CommentStepDef() {

        Given("^I navigate to: '(.*)'$", (String url) -> {
            driver().navigate().to(url);
        });

        Given("^I login as audience member with email '(.*)' and password '(.*)'$", (String email, String pass) -> {
            new ArticlePage(driver())
                    .openSignInPage()
                    .signIn(email, pass);
        });
    }
}
