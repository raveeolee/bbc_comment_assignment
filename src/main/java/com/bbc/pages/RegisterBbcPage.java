package com.bbc.pages;

import com.bbc.pages.base.BaseView;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * Register with BBC page.
 */
public class RegisterBbcPage extends BaseView {

    public RegisterBbcPage(SearchContext context) {
        super(context);
    }

    public WebElement title() {
        return $("h1");
    }
}
