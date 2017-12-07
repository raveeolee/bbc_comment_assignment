package com.bbc.news.comment.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by oleh on 07/12/17.
 */
public class CommentStepDef {

    @Given("^I am audience member$")
    public void iAmAudienceMember() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I navigate to: '(.*)'$")
    public void iNavigateTo(String url) {
        throw new PendingException();
    }
}
