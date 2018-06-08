package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class DatasetPage extends AbstractPage {

    public DatasetPage() {
        super();
        this.url = "https://data.mos.ru/opendata/7705031674-adresniy-reestr-zdaniy-i-soorujeniy-v-gorode-moskve";
    }

    public AbstractPage navigate() {
        return super.navigate(this.getClass());
    }

    @Override
    public AbstractPage waitPageLoaded() {
        $(".rows").waitWhile(visible, 30000);
        return this;
    }

    public SelenideElement getFirstColumn()
    {
        return $("#rows-caption > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > div:nth-child(1)");
    }

    public SelenideElement getIdColumn()
    {
        return $("#rows-caption > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(1) > div:nth-child(2)");
    }

    public SelenideElement getIdCell()
    {
        return $("[data-tooltip-info]");
    }

    public SelenideElement getMapIcon()
    {
        return $(".hasGeodata > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(3)");
    }

    public SelenideElement getCopyButton()
    {
        return $(".hasGeodata > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(4)");
    }

    public SelenideElement getMap()
    {
        return $("#mapCard");
    }

    public SelenideElement getSelectedAddress()
    {
        return $("div.leaflet-container:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > svg:nth-child(1) > g:nth-child(1) > path:nth-child(1)");
    }

    public SelenideElement getDropColumnsLink()
    {
        return $("#dropColumnsLink");
    }

    public SelenideElement getDropColumns()
    {
        return $("#dropColumns");
    }


    public SelenideElement getElementInDropColumns()
    {
        return $("#dropColumns > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3)");
    }

    public SelenideElement getColumn()
    {
        return $("#rows-content > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(3)");
    }

    public SelenideElement getFirstId()
    {
        return $(".hasGeodata > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > span:nth-child(1)");
    }

    public SelenideElement getSecondId()
    {
        return $(".hasGeodata > tr:nth-child(2) > td:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > span:nth-child(1)");
    }
}
