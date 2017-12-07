package com.bbc.news.comment.steps;

import com.bbc.news.runner.BaseStepDef;
import env.BrowserFactory;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleh on 07/12/17.
 */
public class CommentStepDef extends BaseStepDef {

    public CommentStepDef() {

        Given("^I am audience member$", () -> {
            WebDriver driver = BrowserFactory.driver();
        });

        And("^I navigate to: '(.*)'$", (String url) -> {
            BrowserFactory.driver().navigate().to(url);
        });


    }
}
