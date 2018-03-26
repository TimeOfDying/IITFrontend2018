package com.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends AbstractPage {
    public SearchPage() {
        super();
        this.url = "https://data.mos.ru/Search";
    }

    public AbstractPage navigate() {
        return super.navigate(this.getClass());
    }

    @Override
    public AbstractPage waitPageLoaded() {
        $(".result-list").waitUntil(visible, 30000);
        return this;
    }

    public CategoryItemDataPage getSelectedItem() {
        CategoryItemDataPage category = new CategoryItemDataPage();
        category.setSelf($(".items-list .selected"));
        return category;
    }

    public SelenideElement getSearchField() {
        return $("input#text");
    }

    public SelenideElement getOverallNumberElement() {
        return getSearchTypeElement("Всего найдено:").$("strong");
    }

    public SelenideElement getSearchTypeElement(String text) {
        return $(byText(text));
    }

    public ElementsCollection getHighlightedElements() {
        return $$("em");
    }
}
