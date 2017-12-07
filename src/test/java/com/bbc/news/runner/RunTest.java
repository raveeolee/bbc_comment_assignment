package com.bbc.news.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Cucumber junit configuration.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format   = { "pretty", "html:target/cucumber" },
        features = { "classpath:com.bbc.news" },
        glue     = { "com.bbc.news.comment.steps" }
)
public class RunTest {}
