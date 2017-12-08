package com.bbc.pages.comment;

import com.bbc.pages.base.BaseView;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * Implementation of a single comment component.
 */
public class Comment extends BaseView {

    public Comment(SearchContext parent) {
        super(parent);
    }

    public WebElement author() {
        return $("h4 a");
    }

    public WebElement text() {
        return $(".cmt-text");
    }
}
