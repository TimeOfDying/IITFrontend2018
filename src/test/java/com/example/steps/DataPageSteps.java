package com.example.steps;

import com.example.pages.DataPage;

import static com.codeborne.selenide.Condition.*;

public class DataPageSteps extends BaseSteps<DataPage> {

    public DataPageSteps() {
        page = new DataPage();
    }

    public DataPageSteps openPage() {
        page.navigate().shouldBeOpened();
        return this;
    }

    public DataPageSteps checkElementsExists()
    {
        getPage().getDatasetNumber().shouldBe(visible);
        getPage().getDatasetCaption().shouldBe(visible);
        getPage().getDatasetDescIcon().shouldBe(visible);
        getPage().getDatasetIcon().shouldBe(visible);
        getPage().getExport().shouldBe(visible);
        getPage().getPassport().shouldBe(visible);
        return this;
    }

    public DataPageSteps clickOnDescIcon()
    {
        getPage().getDatasetDescIcon().click();
        return this;
    }

    public DataPageSteps checkDropDescStatus(String iconStatus)
    {
        if(iconStatus == "true")
        {
            getPage().getDatasetDescIcon().shouldHave(attribute("aria-expanded", iconStatus));
            getPage().getDropDesc().shouldBe(visible);
        }
        else
        {
            getPage().getDatasetDescIcon().shouldHave(attribute("aria-expanded",iconStatus));
            getPage().getDropDesc().shouldNotBe(visible);
        }
        return this;
    }

    public DataPageSteps clickOnExportButton()
    {
        getPage().getExport().click();
        return this;
    }

    public DataPageSteps clickOnJsonExportFormat()
    {
        getPage().getJsonExport().click();
        return this;
    }

    public DataPageSteps checkExportMenuVisibility(String expectedValue)
    {
        getPage().getExport().shouldHave(attribute("aria-expanded",expectedValue));
        return this;
    }
}
