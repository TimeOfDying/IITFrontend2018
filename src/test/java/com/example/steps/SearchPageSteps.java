package com.example.steps;

import com.example.pages.SearchPage;
import org.hamcrest.Matcher;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;

public class SearchPageSteps extends BaseSteps<SearchPage> {
    public SearchPageSteps() {
        page = new SearchPage();
    }

    public SearchPageSteps openPage() {
        page.navigate().shouldBeOpened();
        return this;
    }


    public SearchPageSteps checkSearchInputValue(String expectedValue) {
        getPage().getSearchField().shouldHave(value(expectedValue));
        return this;
    }

    public SearchPageSteps checkOverallNumberExist() {
        getPage().getOverallNumberElement().should(matchText("\\d+"));
        return this;
    }

    public SearchPageSteps checkSearchTypeExists(String type) {
        getPage().getSearchTypeElement(type).shouldBe(visible);
        return this;
    }

    public SearchPageSteps checkSearchTypeSelected(String type) {
        getPage().getSearchTypeElement(type).shouldHave(cssClass("active"));
        return this;
    }

    public SearchPageSteps checkElementsHighlighted(Matcher<String> textMatcher) {
        List<String> highlightedElementsTexts = getPage().getHighlightedElements()
                .stream()
                .map(el -> el.text().toLowerCase())
                .collect(Collectors.toList());
        assertThat(highlightedElementsTexts, everyItem(textMatcher));
        return this;
    }
}
