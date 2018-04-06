package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.components.CategoryItemDataPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DataPage extends AbstractPage {
    public DataPage() {
        super();
        this.url = "https://data.mos.ru/opendata";
    }

    public AbstractPage navigate() {
        return super.navigate(this.getClass());
    }

    @Override
    public AbstractPage waitPageLoaded() {
        $(".loader-block").waitWhile(visible, 30000);
        return this;
    }

    public CategoryItemDataPage getSelectedItem() {
        CategoryItemDataPage category = new CategoryItemDataPage();
        category.setSelf($(".items-list .selected"));
        return category;
    }

    public SelenideElement getDatasetNumber()
    {
        return $(".dataset-icon");
    }

    public SelenideElement getDatasetIcon() {

        return $(".dataset-icon");
    }

    public SelenideElement getDatasetCaption()
    {
        return $(".dataset-caption");
    }

    public SelenideElement getDatasetDescIcon()
    {
        return $(".dataset-desc-icon");
    }

    public SelenideElement getExport()
    {
        return $("#dropDepartmentsLink");
    }

    public SelenideElement getPassport()
    {
        return $("#dropPassportLink");
    }

    public SelenideElement getDropDesc()
    {
        return $("#dropDesc");
    }

    public SelenideElement getJsonExport()
    {
        return $("[onclick*=json]");
    }

}
