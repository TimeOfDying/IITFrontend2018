package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

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

    public SelenideElement getTable()
    {
        return $("#rows");
    }

    public SelenideElement getIdCell()
    {
        return $("[data-tooltip-info]");
    }

    public SelenideElement getMapIcon()
    {
        return $(".map-card-link");
    }

    public SelenideElement getCopyButton()
    {
        return $(".tooltip-hint");
    }

    public SelenideElement getMap()
    {
        return $("#mapCard");
    }

    public SelenideElement getSelectedMapIcon()
    {
        return $(".map-card-link r1 selected");
    }

}
